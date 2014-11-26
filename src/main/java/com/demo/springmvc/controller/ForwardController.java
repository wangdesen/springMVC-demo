package com.demo.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/forward")
public class ForwardController {

	@RequestMapping("/test")
	public ModelAndView forward(ModelAndView modelAndView) {
		modelAndView.setViewName("forward:/freemarker/test");
		return modelAndView;
	}
	
	

}
