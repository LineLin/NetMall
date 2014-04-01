package com.line.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.line.web.model.Commodity;

@Controller
@RequestMapping("/commodity")
public class CommodityController {
	
	@RequestMapping("/add")
	public String addCommodity(Commodity commodity){
		
		return null;
	}
}
