package com.demo.springmvc.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.springmvc.model.User;
import com.demo.springmvc.service.IGenericService;

@Controller
@RequestMapping("/user")
public class UserController extends GenericController<User, Integer> {

	@Resource(name = "userService")
	public void setGenericService(IGenericService<User, Integer> genericService) {
		this.genericService = genericService;
	}

}
