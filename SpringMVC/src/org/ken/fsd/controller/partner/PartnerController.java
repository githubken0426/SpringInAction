package org.ken.fsd.controller.partner;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.ken.fsd.entity.Partner;
import org.ken.fsd.service.partner.PartnerService;
import org.ken.fsd.util.GeneratorSignUtil;
import org.ken.fsd.view.JsonObjectView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 合作伙伴
 * @author ken
 * 
 * @date 2017年7月7日 上午9:33:36
 */
@Controller
@RequestMapping(value="/v1/open/partner")
public class PartnerController {
	@Autowired
	private PartnerService partnerService;
	
	/**
	 * 
	 * http://localhost:8089/SpringMVC/v1/open/partner/register/kioo/buladuo
	 * 
	 * @param name
	 * @param partnerId
	 * @param request
	 * @param response
	 * @param partner
	 * @return
	 * @throws UnsupportedEncodingException
	 * @date 2017年7月7日 下午1:05:13
	 */
	@ResponseBody
	@RequestMapping(value = "/register/{name}/{partnerId}", method = RequestMethod.GET)
	public JsonObjectView registerPartner(@PathVariable String name, @PathVariable String partnerId,
			HttpServletRequest request, HttpServletResponse response,Partner partner)throws UnsupportedEncodingException {
		JsonObjectView jsonResult = new JsonObjectView();
		
		String id=GeneratorSignUtil.generateUUID();
		partner.setId(id);
		partner.setCreateid(id);
		partner.setPartnerid(partnerId);
		partner.setPartnerName(name);
		partner.setSerurityKey(DigestUtils.md5Hex("admin".getBytes("utf-8")));
		partnerService.insertPartner(partner);
		jsonResult.setResult("注册成功！");
		return jsonResult;
	}
	
	@Autowired
	@Qualifier("partnerService")
	private PartnerService testService;
	
	@ResponseBody
	@RequestMapping(value = "/query/{id}", method = RequestMethod.GET)
	public JsonObjectView quseryPartner(@PathVariable String id,Partner partner)
			throws Exception {
		JsonObjectView jsonResult = new JsonObjectView();
		System.out.println("partner:"+testService);
		
		partner=testService.selectByPrimaryKey(id);
		jsonResult.setResult(partner);
		return jsonResult;
	}
}
