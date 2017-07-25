package org.fsd.com.controller;

import javax.servlet.http.HttpServletRequest;

import org.fsd.com.entity.Partner;
import org.fsd.com.service.PartnerService;
import org.fsd.com.test.MinaClientSample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/v1/partner")
public class PartnerController {
	@Autowired
	private PartnerService partnerService;

	@RequestMapping(value = "/{primaryKey}", method = RequestMethod.GET)
	public ModelAndView login(@PathVariable String primaryKey, HttpServletRequest request, ModelAndView view) {
		view.setViewName("index");
		MinaClientSample.testSend("127.0.0.1",3096);
		Partner partner =partnerService.selectByPrimaryKey(primaryKey);
		view.addObject("partner", partner);
		return view;
	}
}
