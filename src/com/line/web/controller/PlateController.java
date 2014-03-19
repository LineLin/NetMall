package com.line.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.line.web.model.Plate;
import com.line.web.service.PlateService;
import com.line.web.utils.Page;
import com.line.web.view.support.PlateInfo;

@Controller
@RequestMapping("/plate")
public class PlateController {
	
	@Autowired
	private PlateService plateService;
	
	@RequestMapping("/itemlist/second/{id}")
	public String showSecondPlate(@PathVariable("id") String plateId,ModelMap model){
		Plate p = plateService.getPlate(plateId);
		List<PlateInfo> pInfo = plateService.getSubPlateInfo(p, p.getLevel()+1,Page.ITEMLIST);
//		pInfo = plateService.getPopularCommodity(pInfo, property, count);
		return null;
	}
}
