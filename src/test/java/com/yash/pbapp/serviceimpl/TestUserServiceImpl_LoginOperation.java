package com.yash.pbapp.serviceimpl;




import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.pbapp.configuration.SpringRootConfig;
import com.example.pbapp.domain.User;
import com.example.pbapp.exception.BlockUserException;
import com.example.pbapp.service.UserService;

public class TestUserServiceImpl_LoginOperation {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserService userService = ctx.getBean(UserService.class);
		
		try {
			User user = userService.login("arju","1");
			if(user==null) {
				System.out.println("wrong login name or password");
			}else {
			System.out.println(user.getName());
			}
		} catch (BlockUserException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
}
