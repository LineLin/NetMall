package com.line.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.line.web.model.Commodity;
import com.line.web.model.Shop;
import com.line.web.model.User;
import com.line.web.service.CommodityService;
import com.line.web.service.ShopService;
import com.line.web.service.UserService;

@Controller
@RequestMapping("/shop")
@SessionAttributes({"user"})
public class ShopManagerController {
	
	@Autowired
	private ShopService shopService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CommodityService commodityService;
	
	@RequestMapping("/index")
	public String index(){
		return "/shop/index.vm";
	}
	
	/**
	 * 功能：为用户添加店铺
	 * @param model
	 * @param shop
	 * @return
	 */
	@RequestMapping("/save/shop")
	public String saveShop(ModelMap model,Shop shop,@ModelAttribute User user){
		System.out.println(shop.getName());
		if(shopService.checkShopInfo(shop)){
			shop.setShopKeeper(user);
			shopService.saveShop(shop);
			return "redirect:/shop/index";
		}else{
			model.addAttribute("error","店名已存在");
			return "forward:/shop/add";
		}
	}
	
	@RequestMapping("/open")
	public String openShop(){
		return "/shop/openshop";
	}
	
	@RequestMapping("/add/commodity")
	public String addCommodity(){
		return "/shop/publiccom";
	}
	
	@RequestMapping("/show/comitemlist")
	public String listAllCommodity(@ModelAttribute("user") User user,ModelMap model){
		Shop shop = user.getShop();
		List<Commodity> comList = commodityService.getCommoditiesByShop(shop);
		model.addAttribute("commodityList",comList);
		return "/shop/mailbaobei";
	}
}
