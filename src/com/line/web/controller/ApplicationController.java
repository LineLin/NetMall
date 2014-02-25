package com.line.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	@RequestMapping("/t")
	public ModelAndView index(@ModelAttribute("user") User user){
		
		ModelAndView md = new ModelAndView("index");
		
		if(user != null){
			md.addObject("userId", user.getId());
			md.addObject("userName",user.getName());
		}else{
			md.addObject("userName","游客");
		}
		
		List<Plate> pList = appData.getTopLevelPlate();
		
		if(pList.isEmpty()){
			System.out.print("dsad");
			pList = appData.initData();
		}
		System.out.println("-----------------------------------------");
//		md.setViewName("index");
		return md;
	}
}
