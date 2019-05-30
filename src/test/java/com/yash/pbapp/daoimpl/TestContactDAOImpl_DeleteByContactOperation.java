package com.yash.pbapp.daoimpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.pbapp.configuration.SpringRootConfig;
import com.example.pbapp.dao.ContactDAO;
import com.example.pbapp.domain.Contact;


public class TestContactDAOImpl_DeleteByContactOperation {
public static void main(String[] args) {
	ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
	ContactDAO contactDAO = ctx.getBean(ContactDAO.class);
	Contact contact = new Contact();
	contact.setId(1);
	contact.setUserid(1);
	contact.setName("abc");
	contact.setPhone("1234556");
//	contact.setGroup_name("yash");
	contact.setAddress("a-24");
	contact.setEmail("a@y");
	contact.setRemark("Me");
	
	contactDAO.delete(contact);
	System.out.println("contact deleted");
}
}
