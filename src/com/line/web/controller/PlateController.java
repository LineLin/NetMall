package com.line.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;

import com.line.web.model.Plate;
import com.line.web.service.PlateService;
import com.line.web.sys.SysSetting;
import com.line.web.utils.Page;
import com.line.web.view.support.PlateInfo;

@Controller
@RequestMapping(value="/plate")
public class PlateController {
	
	@Autowired
	private PlateService plateService;
	
	/**
	 * 功能：显示一级板块页面
	 * @param plateId 一级板块id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/itemlist/first/{id}")
	public String showFirstPlate(@PathVariable("id") String plateId,Model model){
		Plate p = plateService.getPlate(plateId);
		List<PlateInfo> pInfo = plateService.getSubPlateInfo(p, p.getLevel()+2,Page.FIRSR);
		pInfo = plateService.getPopularCommodity(pInfo,"sales",SysSetting.getPageCommodityCount(Page.SECOND));
		model.addAttribute("plates",pInfo);
		return "itemlist/first";
	}
	
	@RequestMapping(value="/itemlist/second/{id}")
	public String showSecondPlate(@PathVariable("id") String plateId,Model model){
		Plate p = plateService.getPlate(plateId);
		List<PlateInfo> pInfo = plateService.getSubPlateInfo(p, p.getLevel()+1,Page.SECOND);
		pInfo = plateService.getPopularCommodity(pInfo,"sales",SysSetting.getPageCommodityCount(Page.SECOND));
		model.addAttribute("plates",pInfo);
		return "itemlist/second";
	}
	
}
