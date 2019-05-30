package com.yash.pbapp.serviceimpl;




import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.pbapp.configuration.SpringRootConfig;
import com.example.pbapp.domain.Contact;
import com.example.pbapp.domain.User;
import com.example.pbapp.exception.BlockUserException;
import com.example.pbapp.service.ContactService;
import com.example.pbapp.service.UserService;

public class TestContactServiceImpl_FreeTextSearchOperation {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		ContactService contactService = ctx.getBean(ContactService.class);
		
			List<Contact> contacts = contactService.findUserContact(3, "ya");
			for (Contact contact : contacts) {
				System.out.println(contact.getPhone());
			}
		
		
	}
}
