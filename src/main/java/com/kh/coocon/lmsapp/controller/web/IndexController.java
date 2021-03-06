package com.kh.coocon.lmsapp.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	
	@RequestMapping(value="/")
	public ModelAndView showHome(){		
		return new ModelAndView("redirect:users/dashboard");		
	}
	
	@RequestMapping(value="/uploading")
	public String uploadingFile(){
		return "/upload";
	}
}
