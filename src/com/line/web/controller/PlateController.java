package com.line.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.line.web.model.Plate;
import com.line.web.service.PlateService;

@Controller
@RequestMapping("/plate")
public class PlateController {
	
	@Autowired
	private PlateService plateService;
	
	@RequestMapping("/itemlist/second/{id}")
	public String showSecondPlate(@PathVariable("id") String plateId,ModelMap model){
		Plate p = plateService.getPlate(plateId);
//		p.s
		return null;
	}
}
