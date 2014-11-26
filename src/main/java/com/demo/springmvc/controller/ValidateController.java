package com.demo.springmvc.controller;

import java.security.NoSuchAlgorithmException;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.springmvc.model.User;

@Controller
@RequestMapping(value = "/validate")
public class ValidateController {
	
	//暴露表单引用对象为模型数据
	@ModelAttribute("user")
	public User getUser() {
		return new User();
	}

	@RequestMapping(value = "/test", method = { RequestMethod.GET })
	public String test(Model model) {
		if (!model.containsAttribute("user")) {
			model.addAttribute("user", new User());
		}
		return "validate";
	}

	@RequestMapping(value = "/test", method = { RequestMethod.POST })
	public String test(Model model, @Valid @ModelAttribute("user") User validateModel, BindingResult result) throws NoSuchAlgorithmException {
		// 如果有验证错误 返回到form页面
		if (result.hasErrors())
			return "validate";
		return "success";
	}
}
