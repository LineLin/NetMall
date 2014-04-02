package com.line.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.line.web.model.User;
import com.line.web.service.UserService;

@Controller
@RequestMapping("/user")
@SessionAttributes({"user","checkcode"})
@SuppressWarnings("unchecked")
public class UserManagerController{
	
	@Autowired
	private UserService userService;
		
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public ModelMap login(@RequestBody User a,ModelMap model){
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
	@RequestMapping("/register")
	public String regist(){
		return "/itemlist/register";
	}
	
	@RequestMapping("/save")
	public String saveUser(User user,Model model){
		
		if(!userService.checkFormat(user.getAccount(),user.getPassword())){
			model.addAttribute("errorMsg","账户和密码不能为空");
			return "forward:/user/register"; 
		}
		
		boolean exist = userService.isUserExist(user.getAccount());
		
		if(exist){
			model.addAttribute("errorMsg","账户已存在");
			return "forward:/user/register";
		}
		
		userService.saveUser(user);
		model.addAttribute("user",user);
		
		return "forward:/";
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/ajax/code",method=RequestMethod.GET)
	@ResponseBody
	public Map verifyCode(String code,@ModelAttribute("checkcode") String checkcode){
		code = code.trim().toLowerCase();
		System.out.println(checkcode);
		HashMap model = new HashMap();
		if(code.equals(checkcode)){
			model.put("flage",true);
		}else{
			model.put("flage",false);
		}
		return model;
	}
}
