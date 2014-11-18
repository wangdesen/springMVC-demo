package com.demo.springmvc.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.springmvc.model.User;
import com.demo.springmvc.service.IGenericService;

@Controller
@RequestMapping("/freemarker")
public class FreemarkerController extends GenericController<User, Integer> {

	@Resource(name = "userService")
	public void setGenericService(IGenericService<User, Integer> genericService) {
		this.genericService = genericService;
	}

	@RequestMapping(value = "test")
	public ModelAndView testfreemarkerview(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("desc", "this is a freemarker test");
		User user = genericService.findById(1);
		mav.addObject(user);
		//返回视图为配置的前缀+名称+配置的后缀：/freemarker/test.html
		mav.setViewName("test");
		return mav;
	}
}
