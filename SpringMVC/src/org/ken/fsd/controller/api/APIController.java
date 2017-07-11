package org.ken.fsd.controller.api;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.ken.fsd.SecurityApiProperties;
import org.ken.fsd.entity.Apimapping;
import org.ken.fsd.service.apimap.ApimappingService;
import org.ken.fsd.util.GeneratorSignUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 联通api相关接口
 * 
 * @author ken 2017-1-18 下午03:21:12
 */
@Controller
@RequestMapping("/v1")
public class APIController {
	@Autowired
	private ApimappingService apimappingService;

	/**
	 * 接口调用
	 * 
	 * @param request
	 * @return 2017-1-19 上午08:43:47
	 */
	@ResponseBody
	@RequestMapping(value = "/call", method = RequestMethod.POST)
	public JSONObject call(HttpServletRequest request, HttpServletResponse response) {
		JSONObject jsonResult = null;
		try {
			String chlkey = SecurityApiProperties.WO_SECURITY_API.getValue("WO_CHLKEY"); // 合作伙伴key
			String secretkey = SecurityApiProperties.WO_SECURITY_API.getValue("WO_SECRETKEY");// 加密KEY
			String apiUrl = SecurityApiProperties.WO_SECURITY_API.getValue("WO_API_URL");// 接口域名
			String version = SecurityApiProperties.WO_SECURITY_API.getValue("WO_VERSION");// 版本号
			String apiId = request.getParameter("apiid");// api接口id
			Apimapping mapping = apimappingService.queryByApiId(apiId);
			String apiName = mapping.getUrlup();// 接口id

			String mobile = request.getParameter("mobile");// 手机号
			String productid = request.getParameter("productid");// 产品包id
			String param = version + chlkey + mobile + productid + secretkey;
			String sign = GeneratorSignUtil.generateWoSign(param);
			apiUrl += apiName + "?version=" + version + "&chlkey=" + chlkey + "&mobile=" + mobile + "&productid="
					+ productid + "&sign=" + sign;

			HttpClient httpclient = new HttpClient();
			HttpMethod method = new PostMethod(apiUrl);
			httpclient.executeMethod(method);
			String result = new String(method.getResponseBody(), "utf-8");
			jsonResult = JSONObject.fromObject(result);
			request.setAttribute("jsonResult", jsonResult);
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonResult;
	}
}
