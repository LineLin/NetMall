package com.line.web.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class ApplicationControle{
	
	@RequestMapping(value="/index",method=RequestMethod.POST)
	public ModelAndView index(String name){
			System.out.println("name :" + name + "---ds");
			//ModelAndView view = new ModelAndView("sd.jsp");
		return null;
	}
}
