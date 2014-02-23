package com.line.web.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.line.web.service.UserService;

@Controller
@RequestMapping("/user")
@SessionAttributes("user")
public class UserManagerController{
	
	@Autowired
	private UserService userService;
		
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(String account, String password){
		
		//userService.checkFormat(account, password);
		
		return "forward:index.jsp";
	}
}
