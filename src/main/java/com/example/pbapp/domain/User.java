package com.example.pbapp.domain;

/**
 * This User model is used as a data traveller from layer to layer
 * @author arju.yadav
 *
 */
public class User extends Person {
	
	/**
	 * status of user
	 * 1: Active 2: Block
	 * By default user will be active at registration time
	 */
	private Integer status;
	/**
	 * Role of user
	 * 1: Admin 2: User
	 * By default role will be User
	 */
	private Integer role;
	/**
	 * login name of user
	 */
	private String loginname;
	/**
	 * password of user
	 */
	private String password;

	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
