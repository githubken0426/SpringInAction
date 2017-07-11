package org.ken.fsd.inteceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.ken.fsd.entity.ApiCount;
import org.ken.fsd.entity.Partner;
import org.ken.fsd.entity.Product;
import org.ken.fsd.enums.ErrorCode;
import org.ken.fsd.exception.ApiException;
import org.ken.fsd.service.auth.PartnerAuthService;
import org.ken.fsd.service.partner.PartnerService;
import org.ken.fsd.service.product.ProductService;
import org.ken.fsd.service.statistic.ApiCountService;
import org.ken.fsd.util.GeneratorSignUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 用户认证 接口签名解决方案，通过Spring拦截器方式实现。
 * 
 * @author ken
 * 
 */
public class ApiSignInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	private PartnerService partnerService;
	@Autowired
	private PartnerAuthService partnerAuthService;
	@Autowired
	private ApiCountService apiCountService;
	@Autowired
	private ProductService productService;

	/**
	 * 接口过期时间
	 */
	private static final long OVERDUE_TIME = 30 * 1000;

	/**
	 * 日志记录器
	 */
	private Logger logger = Logger.getLogger(ApiSignInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.debug("ApiSignInterceptor.preHandle()");
		boolean result = true;
		String timestamp = request.getParameter("t");
		// 接口调用过期检查，为防止机器重复调用接口 服务器时间-app接口调用时间 >过期时间
		// t为null报错
		if (System.currentTimeMillis() - Long.parseLong(timestamp) > OVERDUE_TIME) {
			result = false;
			throw new ApiException(ErrorCode.API_TIME_EXPIRED);
		}
		// 判断账号是否合法
		String partnerId = request.getParameter("partnerid");// 合作伙伴
		Partner partner = partnerService.selectByParenterId(partnerId);
		if (partner == null) {
			result = false;
			throw new ApiException(ErrorCode.API_PARTENER_KEY);
		}
		// 验证接口调用身份是否合法 URL签名与服务器生成的签名进行比对
		String productid = request.getParameter("productid");// 产品包id
		String secretKey = partner.getSerurityKey();// 秘钥
		String mobile = request.getParameter("mobile");// 联通手机号
		String apiId = request.getParameter("apiid");// api接口id
		String sign = request.getParameter("sign");
		String generatedSign = GeneratorSignUtil.generateSign(timestamp, partnerId, secretKey, mobile, apiId,
				productid);
		logger.debug("generatedSign-> " + generatedSign);
		if (!generatedSign.equals(sign)) {
			result = false;
			throw new ApiException(ErrorCode.API_SIGN_ERROR);
		}
		// 判断apiid是否合法
		String pid = partner.getId();
		List<String> auth = partnerAuthService.selectAuthByParenterId(pid);
		if (!(auth.size() > 0) || !auth.contains(apiId)) {
			result = false;
			throw new ApiException(ErrorCode.API_API_ID);
		}
		// 判断有效期是否合法
		long validFrom = partner.getValidFrom();
		long validTo = partner.getValidTo();
		if (validFrom <= 0 || validTo <= 0) {
			result = false;
			throw new ApiException(ErrorCode.API_VALIDATE_EXPIRED);
		}
		return result;
	}

	/**
	 * 日志记录 在preHandle中，可以进行编码、安全控制等处理； 在postHandle中，有机会修改ModelAndView；
	 * 在afterCompletion中，可以根据ex是否为null判断是否发生了异常，进行日志记录。
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		String partnerId = request.getParameter("partnerid");// 合作伙伴
		String apiId = request.getParameter("apiid");// api接口id
		String productId = request.getParameter("productid");// 产品包id
		Product product = productService.selectByProductId(productId);

		Partner partner = partnerService.selectByParenterId(partnerId);
		ApiCount count = new ApiCount();
		if (partner != null) {
			count.setPartnerid(partner.getId());
		}
		count.setId(GeneratorSignUtil.generateUUID());
		count.setApiid(apiId);
		if (product != null) {
			count.setProductid(product.getId());
			count.setMoney(product.getMoney());
		}
		JSONObject json = JSONObject.fromObject(request.getAttribute("jsonResult"));
		String resultCode = json.getString("resultCode");
		count.setStatus(resultCode);
		String resultDesc = json.getString("resultDesc");
		count.setMemo(resultDesc);

		apiCountService.insert(count);
		// super.afterCompletion(request, response, handler, ex);
	}

}