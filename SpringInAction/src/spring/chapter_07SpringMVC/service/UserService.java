package spring.chapter_07SpringMVC.service;

import spring.chapter_07SpringMVC.bean.User;




public interface UserService {
	/**
	 * 登陆
	 * @param user
	 * @return
	 */
	public User userLogin(User user);
	
	public User getById(int id);
	
	public int insertUser(User user);
}
