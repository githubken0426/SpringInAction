package spring.chapter_09SpringSecurity.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表
 * @author Administrator
 * 2016-5-30 下午04:00:42
 *
 */
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String realName;
	private String account;
	private String password;
	private Date createTime;
	private Date updateTime;
	private String comments;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
}
