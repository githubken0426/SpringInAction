package spring.chapter_09SpringSecurity.dao;

import org.springframework.stereotype.Repository;

import spring.chapter_09SpringSecurity.bean.User;


@Repository
public interface UserDao {
	/**
	 * 登陆
	 * @param user
	 * @return
	 */
	public User userLogin(User user);
}
