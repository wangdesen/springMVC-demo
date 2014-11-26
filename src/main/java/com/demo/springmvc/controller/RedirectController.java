package com.demo.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/redirect")
public class RedirectController {

	@RequestMapping("/test")
	public ModelAndView redirect(ModelAndView modelAndView) {
		//直接返回视图页面
		modelAndView.setViewName("redirect:/redirect.jsp");
		return modelAndView;
	}
	
	

}
