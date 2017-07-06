package spring.chapter_09SpringSecurity.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import spring.chapter_09SpringSecurity.bean.User;
import spring.chapter_09SpringSecurity.service.UserService;

@Controller
@RequestMapping(value="/account")
public class UserController {
	private User user;
	
	@Autowired
	private UserService userService;
	
	/**
	 * 用户登录
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request,@ModelAttribute User user) throws Exception{
		ModelAndView mv = new ModelAndView("index");
		try {
			User loginUser=userService.userLogin(user);
			System.out.println(loginUser);
			if(null==loginUser){
				mv.setViewName("login");
			}else{
				request.getSession().setAttribute("loginUser", loginUser);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.POST)
	public ModelAndView logout(HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("login");
//		request.getSession().removeAttribute("loginUser");
		return mv;
	}
}
