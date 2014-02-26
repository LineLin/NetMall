package com.line.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.line.web.model.Plate;
import com.line.web.model.User;
import com.line.web.service.AppDataService;

@Controller
public class ApplicationController {
	
	@Autowired
	private AppDataService appData;
	
	@RequestMapping("/index")
	public String index(@ModelAttribute("user") User user,BindingResult result,Model model){
		
		if(result.hasErrors()){
			System.out.println("error");
		}
		
		if(user != null){
			model.addAttribute("userId", user.getId());
			model.addAttribute("userName",user.getName());
		}else{
			model.addAttribute("userName","游客");
		}
		
		List<Plate> pList = appData.getTopLevelPlate();
		
		if(pList.isEmpty()){
			pList = appData.initData();
		}
		model.addAttribute("pList",pList);
		System.out.println("-----------------------------------------");

		return "index";
	}
}
