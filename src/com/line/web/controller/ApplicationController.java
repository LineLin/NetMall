package com.line.web.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.line.web.model.User;
import com.line.web.service.AppDataService;
import com.line.web.utils.CheckCodeProductor;
import com.line.web.view.support.PlateInfo;

@Controller
@SessionAttributes("checkcode")
public class ApplicationController {
	
	@Autowired
	private AppDataService appData;
	
	@RequestMapping("/index")
	public String index(HttpServletRequest request,Model model){
		
		User user = (User) request.getSession().getAttribute("user");
		if(user != null){
			model.addAttribute("userId", user.getId());
			model.addAttribute("userName",user.getName());
		}
		
		List<PlateInfo> pList;
		
		pList = appData.getIndexPlateInfo();
		
		pList = appData.getCommoShowList(pList, null);
		
		model.addAttribute("pLists",pList);
		
		return "index";
	}
	
	@RequestMapping("/checkcode")
	public void getCheckCode(HttpServletResponse resp,Model model){
		
		//获取验证码图片和字符串
		CheckCodeProductor productor = new CheckCodeProductor();
		BufferedImage image = productor.getCodeImage();
		String code = productor.getCode();
		
//		req.getSession().setAttribute("checkcode",code);
		
		model.addAttribute("checkcode",code);
		//禁止图片缓存
		resp.setHeader("Pragma", "no-cache");
		resp.setHeader("Cache-Control","no-cache");
		
		resp.setContentType("image/jpeg");
		
		try {
			ServletOutputStream out = resp.getOutputStream();
			ImageIO.write(image, "jpeg",out);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return;
	}
}
