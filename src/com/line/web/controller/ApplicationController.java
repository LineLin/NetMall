package com.line.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.line.web.model.Plate;
import com.line.web.model.User;
import com.line.web.service.AppDataService;

@Controller
public class ApplicationController {
	
	@Autowired
	private AppDataService appData;
	
	@RequestMapping("/")
	public String index(HttpServletRequest request,Model model){
		
		User user = (User) request.getSession().getAttribute("user");
		if(user != null){
			model.addAttribute("userId", user.getId());
			model.addAttribute("userName",user.getName());
		}else{
			model.addAttribute("userName","游客");
		}
		
		List<Plate> pList =null;
		
		if(pList.isEmpty()){
			appData.initData();
		}
		
		model.addAttribute("pList",pList);
		
		return "index";
	}
	
}
