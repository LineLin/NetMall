package com.line.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.line.web.model.Commodity;
import com.line.web.model.Plate;
import com.line.web.service.PlateService;
import com.line.web.sys.SysSetting;
import com.line.web.utils.Page;
import com.line.web.view.support.PlateInfo;

@Controller
@RequestMapping(value="/plate")
public class PlateController {

	private final int COMMODITY_SHOW_PAGE_SIZE = 1;
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
		if(p == null){
			return "redirect:/";
		}
		List<PlateInfo> pInfo = plateService.getSubPlateInfo(p, p.getLevel()+2,Page.FIRSR);
		plateService.getPopularCommodity(pInfo,"sales",SysSetting.getPageCommodityCount(Page.FIRSR));
		model.addAttribute("plates",pInfo);
		return "/itemlist/first";
	}
	
	@RequestMapping(value="/itemlist/second/{id}")
	public String showSecondPlate(@PathVariable("id") String plateId,Model model){
		Plate p = plateService.getPlate(plateId);
		if(p == null){
			return "redirect:/";
		}
		List<PlateInfo> pInfo = plateService.getSubPlateInfo(p, p.getLevel()+1,Page.SECOND);
		plateService.getPopularCommodity(pInfo,"sales",SysSetting.getPageCommodityCount(Page.SECOND));
		model.addAttribute("plates",pInfo);
		return "/itemlist/second";
	}
	
	@RequestMapping(value="/itemlist/items")
	public String showThirdPlate(@RequestParam(value="id") String plateId,int page,
			@RequestParam(value="sortBy",required=false) String sortBy,Model model){
		Plate p = plateService.getPlate(plateId);
		if(p == null){
			return "redirect:/";
		}
		if(sortBy == null){
			sortBy = "sales";
		}
		List<Commodity> list = plateService.getPageCommodity(p, sortBy,false, page, COMMODITY_SHOW_PAGE_SIZE);
		model.addAttribute("commodityList", list);
		return "/itemlist/third";
	}
	
}
