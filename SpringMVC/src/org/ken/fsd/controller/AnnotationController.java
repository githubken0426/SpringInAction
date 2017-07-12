package org.ken.fsd.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.ken.fsd.entity.Pets;
import org.ken.fsd.view.JsonObjectView;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/v1/open/anno")
public class AnnotationController {
	
	/**
	 * @PathVariable注解
	 * 
	 * http://localhost:8089/SpringMVC/v1/open/anno/pets/lili/Labrador
	 * @param ownerId
	 * @param petId
	 * @param model
	 * @date 2017年7月7日 上午11:37:03
	 */
	@ResponseBody
	@RequestMapping("/pets/{ownerId}/{nickname}")
	public JsonObjectView findPet(@PathVariable String ownerId, @PathVariable("nickname") String nickname, Pets pet) {
		JsonObjectView jsonResult = new JsonObjectView();
		
		System.out.println("ownerId="+ownerId);
		System.out.println("nickname="+nickname);
		pet.setOwnerId(ownerId);
		pet.setNickname(nickname);
		jsonResult.setResult(pet);
		return jsonResult;
	}
	
	/**
	 * @RequestParam 常用来处理简单类型的绑定
	 * http://localhost:8089/SpringMVC/v1/open/anno/pets/find?age=10
	 * 
	 * @param age
	 * @param request
	 * @return
	 * @date 2017年7月7日 下午1:22:33
	 */
	@ResponseBody
	@RequestMapping(value="/pets/find",method=RequestMethod.GET)
	public JsonObjectView findPetById(@RequestParam int age,HttpServletRequest request) {
		JsonObjectView jsonResult = new JsonObjectView();
		
		String requestAge=request.getParameter("age");
		System.out.println("age="+age+",requestAge"+requestAge);
		
		jsonResult.setResult(age);
		return jsonResult;
	}
	
	/**
	 * 使用ModelAndView返回视图层
	 * http://localhost:8089/SpringMVC/v1/open/anno/index
	 * @return
	 * @date 2017年7月10日 上午9:10:32
	 */
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public ModelAndView toIndex(HttpServletRequest request,Model model,ModelAndView view){
		 //指定返回的视图(jsp)
        view.setViewName("index");
        
		//1.放在model里 建议使用  
        model.addAttribute("mode", "modeValue");  
        //2.放在request里  
        request.setAttribute("request", "requestValue");  
        //3 放在ModelAndView
        view.addObject("ModelAndView", "ModelAndViewValue"); 
        //4.放入session
        HttpSession session=request.getSession();
        session.setAttribute("session", "sessionValue");
        
        //存list数据
        List<String> list=new ArrayList<String>();
        for(int i=1;i<5;i++)
        	list.add(i+"");
        view.addObject("listValue", list); 
		return view;
	}
	/**
	 * @RequestBody 
	 * @RequestBody String ownerId,
	 * @param json_data
	 * @param request
	 * @return
	 * @date 2017年7月7日 下午1:38:01
	 *
	@ResponseBody
	@RequestMapping(value="/json/find",method=RequestMethod.POST)
	public JsonObjectView findRequestBody(@RequestBody Pets pet,HttpServletRequest request) {
		JsonObjectView jsonResult = new JsonObjectView();
		jsonResult.setResult(pet);
		System.out.println(pet);
		return jsonResult;
	}*/

}
