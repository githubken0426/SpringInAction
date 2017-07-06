package spring.chapter_07SpringMVC.dao;

import org.springframework.stereotype.Repository;

import spring.chapter_07SpringMVC.bean.User;



@Repository
public interface UserDao {
	/**
	 * 登陆
	 * @param user
	 * @return
	 */
	public User userLogin(User user);
	
	public User getById(int id);
	
	public int insertUser(User user);
	
}
