package org.fsd.com.controller;

import javax.servlet.http.HttpServletRequest;

import org.fsd.com.entity.Partner;
import org.fsd.com.mina.client.MinaClientSample;
import org.fsd.com.service.PartnerService;
import org.fsd.com.view.JsonObjectView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(value = "/v1/partner")
public class PartnerController {
	@Autowired
	private PartnerService partnerService;
	
	@ResponseBody
	@RequestMapping(value = "/{primaryKey}", method = RequestMethod.GET)
	public JSONObject login(@PathVariable String primaryKey, HttpServletRequest request,JsonObjectView view) {
		Partner partner =partnerService.selectByPrimaryKey(primaryKey);
		view.setResult(partner);
		JSONObject json =JSONObject.fromObject(view);
		MinaClientSample.testSend(json);
		return json;
	}
}
