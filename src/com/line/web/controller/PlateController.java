package com.line.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.line.web.service.PlateService;

@Controller
@RequestMapping("/plate")
public class PlateController {
	
	@Autowired
	private PlateService plateService;
	
	@RequestMapping("/itemlist/second")
	public void showSecondPlate(String plateId){
//		Plate plate = plateService
	}
}
