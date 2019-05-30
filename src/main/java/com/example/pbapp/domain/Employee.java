package com.example.pbapp.domain;

/**
 * This User model is used as a data traveller from layer to layer
 * @author Anurag.mahajan
 *
 */
public class Employee extends Person {
	
	
	private String loginname;
	/**
	 * password of user
	 */
	private String password;


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
