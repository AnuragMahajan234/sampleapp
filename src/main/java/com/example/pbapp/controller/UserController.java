package com.example.pbapp.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.pbapp.command.LoginCommand;
import com.example.pbapp.command.RegistrationCommand;
import com.example.pbapp.domain.Contact;
import com.example.pbapp.domain.User;
import com.example.pbapp.exception.BlockUserException;
import com.example.pbapp.exception.UserAlreadyExistException;
import com.example.pbapp.service.ContactService;
import com.example.pbapp.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	public ContactService contactService;

	@RequestMapping(value= {"user/dashboard"})
	public String userDashboard() {
		return "user/dashboard_user";
	}
	
	@RequestMapping(value= {"admin/dashboard"})
	public String adminDashboard() {
		return "user/dashboard_admin";
	}
	
	@RequestMapping(value= {"/login"})
	public String login(Model model) {
		model.addAttribute("command", new LoginCommand());
		return "login";
	}
	
	@RequestMapping(value= {"/registration"})
	public String registration(Model model) {
		model.addAttribute("user", new User());
		return "registration";
	}
	
	@RequestMapping(value= {"/authenticate"})
	public String authenticate(@ModelAttribute("command") LoginCommand loginCommand,Model model, HttpSession session) {
		try {
			String strlog = loginCommand.getLoginname();
			String strpas =  loginCommand.getPassword();
			User loggedInUser = userService.login(strlog,strpas);
			if(loggedInUser!=null) {
				if(loggedInUser.getRole().equals(userService.ROLE_ADMIN)) {
					setLoggedInUserInSession(session, loggedInUser);
					return "redirect:/admin/dashboard";
				}
				else if(loggedInUser.getRole().equals(userService.ROLE_USER)) {
					setLoggedInUserInSession(session, loggedInUser);
					return "redirect:/user/dashboard";
				} 
				else {
					model.addAttribute("errMsg", "invalid role");
					return "login";
				}
			} 
			else {
				model.addAttribute("errMsg", "wrong login name or password");
				return "login";
			}
		} catch (BlockUserException e) {
			model.addAttribute("errMsg", e.getMessage());
			return "login";
		}
	}

	@RequestMapping("/validate")
	public String validate(@ModelAttribute("user") User user, Model model) throws UserAlreadyExistException {
		user.setStatus(1);
		user.setRole(2);

		userService.register(user);
		model.addAttribute("msg", "User registered successfully!");
		return "/index";
	}
	
	@RequestMapping("/user/contacts")
	public String userContacts(HttpSession session) {
		int userid = (Integer) session.getAttribute("userid");
		List<Contact> userContacts = contactService.findUserContact(userid);
		session.setAttribute("contacts", userContacts);
		return "contacts";
	}
	
	@RequestMapping("/admin/users")
	public String getUserList(HttpSession session) {
		
		List<User> users = userService.getUserList();
		session.setAttribute("users", users);
		return "users";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}
	
	private void setLoggedInUserInSession(HttpSession session, User loggedInUser) {
		session.setAttribute("loggedInUser", loggedInUser);
		session.setAttribute("userid", loggedInUser.getId());
		session.setAttribute("role", loggedInUser.getRole());
	}
	
}
