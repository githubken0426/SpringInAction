package org.fsd.com.controller;

import javax.servlet.http.HttpServletRequest;

import org.fsd.com.entity.Partner;
import org.fsd.com.mina.client.MinaClient;
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
@RequestMapping(value = "/v1/send")
public class SendController {
	@Autowired
	private PartnerService partnerService;
	/**
	 * 
	 * @param primaryKey
	 * @param request
	 * @param view
	 * @return
	 * @throws 
	 * @date 2017年8月2日 下午1:15:29
	 */
	@ResponseBody
	@RequestMapping(value = "/server/{primaryKey}", method = RequestMethod.GET)
	public JSONObject clientSendToServer(@PathVariable String primaryKey, HttpServletRequest request,JsonObjectView view) {
		Partner partner =partnerService.selectByPrimaryKey(primaryKey);
		view.setResult(partner);
		JSONObject json =JSONObject.fromObject(view);
		MinaClient.clientSendToServer(json);
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/client/{name}", method = RequestMethod.GET)
	public JSONObject serverSendToClient(@PathVariable String name, HttpServletRequest request,JsonObjectView view) {
		view.setResult(name);
		JSONObject json =JSONObject.fromObject(view);
		MinaClient.serverSendToClient(json);
		return json;
	}
}
