package spring.chapter_09SpringSecurity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.chapter_09SpringSecurity.bean.User;
import spring.chapter_09SpringSecurity.dao.UserDao;
import spring.chapter_09SpringSecurity.service.UserService;


@Service(value="userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	
	public User userLogin(User user) {
		return userDao.userLogin(user);
	}

}
