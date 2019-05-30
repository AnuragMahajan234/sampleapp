package com.yash.pbapp.daoimpl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.pbapp.configuration.SpringRootConfig;
import com.example.pbapp.dao.UserDAO;
import com.example.pbapp.domain.User;

public class TestContactDAOImpl_FindByPropertyOperation {
public static void main(String[] args) {
	ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
	UserDAO userDAO = ctx.getBean(UserDAO.class);
	List<User> users = userDAO.findByProperty("role", 1);
	
	for (User user : users) {
		
		System.out.println("user name : "+user.getName());
		System.out.println("user email : "+user.getEmail());
	}
}
}
