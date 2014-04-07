package com.line.web.controller;


import java.io.IOException;

import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.line.web.model.Commodity;
import com.line.web.model.Shop;
import com.line.web.model.User;
import com.line.web.service.ShopService;
import com.line.web.service.UserService;
import com.line.web.utils.FileUploadUtil;

@Controller
@RequestMapping("/shop")
@SessionAttributes({"user"})
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
	
	@RequestMapping(value="/save/commodity",method= RequestMethod.POST)
	public String saveCommodity(Commodity com,@RequestParam("file") Part image){
		System.out.println(com.getName());
		System.out.println(image.getName());
		System.out.println(image.getSize());
		System.out.println(image.getHeaderNames());
		System.out.println(FileUploadUtil.parseFileName(image.getHeader("content-disposition")));
//		try {
////			image.write("test.doc");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		return "";
	}
}
