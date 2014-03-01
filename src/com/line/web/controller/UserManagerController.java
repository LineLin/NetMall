package com.line.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.line.web.model.User;
import com.line.web.service.UserService;

@Controller
@RequestMapping("/user")
@SessionAttributes("user")
public class UserManagerController{
	
	@Autowired
	private UserService userService;
		
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public	@ResponseBody ModelMap login(@RequestBody User a,ModelMap model){
		String account = a.getAccount();
		String password = a.getPassword();
		System.out.println("account: " + account);
		System.out.println("password: " + password);
		if( !userService.checkFormat(account, password)){
			model.addAttribute("errorMsg","账号和密码不能为空，且不带特殊字符");
			return model;
		}
		
		User user = userService.verification(account, password);
		if(user != null){
			model.addAttribute("flag",true);
			model.addAttribute("user",user);
		}else{
			model.addAttribute("flag",false);
			model.addAttribute("errorMsg","账户不存在或密码错误！");
		}
		
		return model;
	}
	
	//页面跳转
	@RequestMapping("/user/regist")
	public String regist(){
		return "regist";
	}
	
	@RequestMapping("/user/save")
	public String saveUser(User user,Model model){
		
		if(!userService.checkFormat(user.getAccount(),user.getPassword())){
			model.addAttribute("errorMsg","账户和密码不能为空");
			return "forward:/user/regist"; 
		}
		
		boolean exist = userService.isUserExist(user.getAccount());
		
		if(exist){
			model.addAttribute("errorMsg","账户已存在");
			return "forward:/user/regist";
		}
		
		userService.saveUser(user);
		model.addAttribute("user",user);
		
		return "forward:/";
	}
}
