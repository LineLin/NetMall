package com.line.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.line.web.model.User;
import com.line.web.service.UserService;

@Controller
@RequestMapping("/user")
@SessionAttributes({"user","userId"})
public class UserManagerController{
	
	@Autowired
	private UserService userService;
		
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(String account, String password,ModelAndView model,RedirectAttributes rdAttr){
		
		if( !userService.checkFormat(account, password)){
			rdAttr.addFlashAttribute("lgErro","账号或密码不能为空！");
			return "redirect:/";
		}
		
		User user = userService.verification(account, password);
		if(user != null){
			model.addObject("user",user);
			model.addObject("userId",user.getId());
		}else{
			rdAttr.addFlashAttribute("lgErro","用户不存在或者密码错误！");
		}
		
		return "redirect:/";
	}
}
