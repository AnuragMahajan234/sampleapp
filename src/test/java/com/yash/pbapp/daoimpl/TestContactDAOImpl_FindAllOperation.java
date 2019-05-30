package com.yash.pbapp.daoimpl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.pbapp.configuration.SpringRootConfig;
import com.example.pbapp.dao.ContactDAO;
import com.example.pbapp.domain.Contact;


public class TestContactDAOImpl_FindAllOperation {
public static void main(String[] args) {
	ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
	ContactDAO contactDAO = ctx.getBean(ContactDAO.class);
	List<Contact> contacts = contactDAO.findAll();
	
		for (Contact contact : contacts) {
			
			System.out.println("contact name : "+contact.getName());
			System.out.println("contact phone : "+contact.getPhone());
		}
	
}
}
