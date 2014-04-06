package com.line.web.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.line.web.model.Shop;
import com.line.web.model.User;
import com.line.web.service.ShopService;
import com.line.web.service.UserService;

@Controller
@RequestMapping("/shop")
@SessionAttributes("user")
public class ShopManagerController {
	
	@Autowired
	private ShopService shopService;
	
	@Autowired
	private UserService userService;
	
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
	@RequestMapping("/save")
	public String saveShop(ModelMap model,Shop shop,@ModelAttribute User user){
		if(shopService.checkShopInfo(shop)){
			shop.setShopKeeper(user);
			shopService.saveShop(shop);
		}else{
			
		}
		return null;
	}

}
