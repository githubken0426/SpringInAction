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

@Controller
@RequestMapping(value = "/v1/partner")
public class PartnerController {
	@Autowired
	private PartnerService partnerService;
	
	@ResponseBody
	@RequestMapping(value = "/{primaryKey}", method = RequestMethod.GET)
	public JsonObjectView login(@PathVariable String primaryKey, HttpServletRequest request, JsonObjectView view) {
		MinaClientSample.testSend("127.0.0.1",3096);
		Partner partner =partnerService.selectByPrimaryKey(primaryKey);
		view.setResult(partner);
		return view;
	}
}
