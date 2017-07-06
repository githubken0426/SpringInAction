package spring.chapter_07SpringMVC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.chapter_07SpringMVC.bean.User;
import spring.chapter_07SpringMVC.dao.UserDao;


@Service(value="userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	
	public User userLogin(User user) {
		return userDao.userLogin(user);
	}

	@Override
	public User getById(int id) {
		return userDao.getById(id);
	}

	@Override
	public int insertUser(User user) {
		return userDao.insertUser(user);
	}

}
