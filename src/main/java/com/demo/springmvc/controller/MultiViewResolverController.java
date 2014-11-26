package com.demo.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/multiView")
public class MultiViewResolverController {

	@RequestMapping("/test1")
	public ModelAndView test1(ModelAndView modelAndView) {
		modelAndView.setViewName("multiView1");
		return modelAndView;
	}
	
	@RequestMapping("/test2")
	public ModelAndView test2(ModelAndView modelAndView) {
		modelAndView.setViewName("multiView2");
		return modelAndView;
	}
	
}
