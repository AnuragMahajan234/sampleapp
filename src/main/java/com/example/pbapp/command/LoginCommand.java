package com.example.pbapp.command;

/**
 * It is a login Command that will be used as a communication medium between login form and UserController. 
 * When user will login, this loginCommand should be available on login form.
 * LoginCommand will be set by UserController at the time of showing the login form. 
 * From login page same command will be received by modelAttribute.
 * 
 * @author anurag.mahajan
 *
 */
public class LoginCommand {

	private String loginname;
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
