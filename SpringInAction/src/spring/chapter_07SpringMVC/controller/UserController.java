package spring.chapter_07SpringMVC.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.chapter_07SpringMVC.bean.User;
import spring.chapter_07SpringMVC.service.UserService;



@Controller
@RequestMapping(value="/user")
public class UserController {
	private User user;
	
	@Autowired
	private UserService userService;
	
	/**
	 * 用户登录
	 * @return
	 * 
	 * @RequestMapping：
	 * 使用rest风格:如SpringInAction/user/login/abc/23456
	 * 指定的参数名称必须和@PathVariable一致并且参数不能为空
	 * 
	 * @PathVariable获取参数值后，再用getParameter()获取不到为null
	 * 
	 */
	//@RequestMapping(value={"login"})
	@RequestMapping(value={"/{name}/{password}","/loginRest/{name}/{password}"},method=RequestMethod.GET)//rest风格,/或者/login均可
	public ModelAndView loginRest(HttpServletRequest request,
			@PathVariable String name,@PathVariable String password,Model model) throws Exception{
		
		ModelAndView mv = new ModelAndView("validateUser");
		String pwd=request.getParameter("password");//此处获取不到值的
		System.out.println(name+","+password+".pwd:"+pwd);
		
		User user =new User();
		user.setAccount("admin");
		user.setPassword("admin");
		User loginUser=userService.userLogin(user);
		request.getSession().setAttribute("loginUser", loginUser);
		System.out.println(loginUser);
		System.out.println("chapter 07");
		
		/**
		 * addAttribute:针对跳转页面sf:form 中的modelAttribute
		 * 可以看到，sf:form页面中的input元素会自动赋值
		 */
		model.addAttribute(loginUser);
		return mv;
	}
	
	/**
	 * @RequestMapping不指定参数名称(不使用rest风格),
	 * 必须？号传参如:SpringInAction/user/login?password=23456
	 * getParameter()获取的参数可以为空
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value={"/login"},method=RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request,Model model) throws Exception{
		
		ModelAndView mv = new ModelAndView("index");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		System.out.println(name+","+password);
		
		User user =new User();
		user.setAccount("admin");
		user.setPassword("admin");
		User loginUser=userService.userLogin(user);
		request.getSession().setAttribute("loginUser", loginUser);
		System.out.println(loginUser);
		System.out.println("chapter 07");
		
		return mv;
	}
	
	/**
	 * @RequestParam:
	 * 必须以?号传参SpringInAction/user/param?id=1
	 * 并且参数必须和@RequestParam指定的一致
	 * 
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/param",method=RequestMethod.GET)
	public ModelAndView testParam(HttpServletRequest request,@RequestParam("id") int id){
		ModelAndView mv = new ModelAndView("index");
		User user=userService.getById(id);
		System.out.println("测试："+user.getAccount());
		return mv;
	}
	
	/**
	 * params属性能够限制处理方法只对包含特定参数(此处如new)的请求处理
	 * @param request
	 * @return
	 */
	@RequestMapping(params="new",method=RequestMethod.GET)
	public ModelAndView testSpitter(HttpServletRequest request){
		ModelAndView mv = new ModelAndView("index");
		System.out.println("包含了查询参数！");
		return mv;
	}
	
	
}
