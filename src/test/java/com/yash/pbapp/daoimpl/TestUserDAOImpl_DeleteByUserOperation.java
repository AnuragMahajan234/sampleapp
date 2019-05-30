package com.yash.pbapp.daoimpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.pbapp.configuration.SpringRootConfig;
import com.example.pbapp.dao.UserDAO;
import com.example.pbapp.domain.User;

public class TestUserDAOImpl_DeleteByUserOperation {
public static void main(String[] args) {
	ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
	UserDAO userDAO = ctx.getBean(UserDAO.class);
	User user = new User();
	user.setId(2);
	user.setName("Arju");
	user.setPhone("123456");
	user.setAddress("Indore");
	user.setEmail("a@a");
	user.setStatus(1);
	user.setRole(1);
	user.setPassword("a");
	userDAO.delete(user);
	System.out.println("user deleted");
}
}
