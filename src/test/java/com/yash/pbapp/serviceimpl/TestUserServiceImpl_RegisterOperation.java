package com.yash.pbapp.serviceimpl;




import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.pbapp.configuration.SpringRootConfig;
import com.example.pbapp.domain.User;
import com.example.pbapp.exception.UserAlreadyExistException;
import com.example.pbapp.service.UserService;

public class TestUserServiceImpl_RegisterOperation {

	public static void main(String[] args) throws UserAlreadyExistException {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserService userService = ctx.getBean(UserService.class);
		User user = new User();
		user.setName("Arju");
		user.setStatus(1);
		user.setRole(1);
		user.setLoginname("arju");
		user.setPassword("123a");
		userService.register(user);
		
		System.out.println("user inserted");
	}
}
