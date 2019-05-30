package com.yash.pbapp.daoimpl;


import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.pbapp.configuration.SpringRootConfig;
import com.example.pbapp.dao.UserDAO;
import com.example.pbapp.domain.User;

public class TestUserDAOImpl_InsertOperation {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO = ctx.getBean(UserDAO.class);
		User user = new User();
		user.setName("Arju");
		user.setStatus(1);
		user.setRole(1);
		user.setLoginname("arju");
		user.setPassword("1");
		try {
			userDAO.save(user);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("user inserted");
	}
}
