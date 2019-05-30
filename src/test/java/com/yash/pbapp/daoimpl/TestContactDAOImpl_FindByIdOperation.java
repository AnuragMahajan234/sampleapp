package com.yash.pbapp.daoimpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.pbapp.configuration.SpringRootConfig;
import com.example.pbapp.dao.ContactDAO;

import com.example.pbapp.domain.Contact;


public class TestContactDAOImpl_FindByIdOperation {
public static void main(String[] args) {
	ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
	ContactDAO contactDAO = ctx.getBean(ContactDAO.class);
	Contact contact = contactDAO.findById(2);
	System.out.println("contact name : "+contact.getName());
}
}
