package org.ken.fsd.controller.server;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import org.ken.fsd.view.JsonView;


@Controller
@RequestMapping("/v1/open")
public class ServerController {

	@ResponseBody
	@RequestMapping(value = "/server", method = RequestMethod.GET)
	public JsonView syncServerTime(HttpServletRequest request) {
		JsonView jv = new JsonView();
		jv.getResult().put("server_time", System.currentTimeMillis());
		return jv;
	}

}
