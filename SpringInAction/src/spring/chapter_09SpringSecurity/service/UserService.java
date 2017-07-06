package spring.chapter_09SpringSecurity.service;

import spring.chapter_09SpringSecurity.bean.User;



public interface UserService {
	/**
	 * 登陆
	 * @param user
	 * @return
	 */
	public User userLogin(User user);
}
