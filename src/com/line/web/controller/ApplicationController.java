package com.line.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.line.web.model.User;
import com.line.web.service.AppDataService;
import com.line.web.sys.SysInit;
import com.line.web.view.support.PlateInfo;

@Controller
public class ApplicationController {
	
	@Autowired
	private AppDataService appData;
	
	@RequestMapping("/index")
	public String index(HttpServletRequest request,Model model){
		
		User user = (User) request.getSession().getAttribute("user");
		if(user != null){
			model.addAttribute("userId", user.getId());
			model.addAttribute("userName",user.getName());
		}
		
		List<PlateInfo> pList;
		
		pList = appData.getIndexPlateInfo();
		
		pList = appData.getCommoShowList(pList, null);
		
		model.addAttribute("pLists",pList);
		
		return "index";
	}
	
}
