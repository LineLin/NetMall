package com.line.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.line.web.model.Shop;
import com.line.web.model.User;
import com.line.web.service.CommodityService;
import com.line.web.service.ShopService;
import com.line.web.service.UserService;
import com.line.web.utils.FileUploadUtil;
import com.line.web.view.support.CommodityForm;

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
	
	private final long maxFileSize =  1024 * 8l; //	1M   
	
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
	public String saveCommodity(CommodityForm form,ModelMap model,@ModelAttribute User user){

		if(form.getPhoto() != null){ 
			String err = FileUploadUtil.checkUploadFile(form.getPhoto(), maxFileSize);
			if(err != null){
				model.addAttribute("errMsg",err);
				return "forward:/shop/add/commodity";
			}
			FileUploadUtil.filesCopy(form.getPhoto(),"com/" + user.getName() + form.getPhoto().getOriginalFilename());
		}
		
		return "";
	}
}
