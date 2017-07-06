package spring.chapter_07SpringMVC.controller;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import spring.chapter_07SpringMVC.bean.User;
import spring.chapter_07SpringMVC.service.UserService;
import spring.util.FileUpload;
import spring.util.UUIDUtil;

@Controller
@RequestMapping(value="/create")
public class CreateController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/saveUser", method=RequestMethod.POST)
	public ModelAndView saveUsers(HttpServletRequest request, @Valid User user,BindingResult result){
		ModelAndView mv = new ModelAndView("index");
		if(result.hasErrors()){
			mv.setViewName("validateUser");
		}
		System.out.println("保存用户！");
		try {
			userService.insertUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			mv.setViewName("validateUser");
		}
		return mv;
	}
	
	/**
	 * 用户注册
	 * 此处应该注意参数绑定的顺序:result应该在@Validated之后
	 * An Errors/BindingResult argumen
	 * @param user
	 * @return
	 * 
	 */
	@RequestMapping(value="/saveUser", method=RequestMethod.POST)
	public ModelAndView saveUser(MultipartHttpServletRequest request, @Valid User user,BindingResult result){
		ModelAndView mv = new ModelAndView("index");
		if(result.hasErrors()){
			mv.setViewName("validateUser");
		}
		System.out.println("保存用户！");
		//上传照片===
		CommonsMultipartFile  imgFile  = (CommonsMultipartFile)request.getFile("profilePhoto");
		//获得文件名
		System.out.println(imgFile.getOriginalFilename());
		String fileName =UUIDUtil.getUUID()+imgFile.getOriginalFilename();
		user.setProfilePhoto(fileName);
		user.setCreateTime(new Date());
		try {
			FileUpload.fileUpload(request,imgFile,fileName);
			userService.insertUser(user);
		} catch (IOException e) {
			e.printStackTrace();
			mv.setViewName("validateUser");
		}
		return mv;
	}
	
	public static void main(String[] args) {
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString();
		String s=str.replaceAll("-","");
		System.out.println(uuid+"--"+s);
	}
}
