package com.demo.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/interceptor")
public class InterceptorController {

	@RequestMapping("/test")
	public ModelAndView test(ModelAndView modelAndView) {
		//直接返回视图页面
		modelAndView.setViewName("main");
		return modelAndView;
	}
	
}
