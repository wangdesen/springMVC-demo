package com.demo.springmvc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.springmvc.util.Log4jUtil;

@Controller
@RequestMapping("/ajax")
public class AjaxController extends Context {


	@RequestMapping(value = "/get1", method = RequestMethod.GET)
	@ResponseBody
	public String get1(ModelMap modelMap) {
		String user = request.getParameter("user");
		Log4jUtil.debug(this, "AjaxController from get1 request user:" + user);
		Map<String, Object> data = new HashMap<String, Object>();
		data.putAll(modelMap);
		modelMap.putAll(data);
		modelMap.addAttribute("type", "get1");
		modelMap.addAttribute("result", "true");
		return modelMap.toString();
	}
	
	@RequestMapping(value = "/get2", method = RequestMethod.GET)
	@ResponseBody
	public String get2(ModelMap modelMap) {
		String user = request.getParameter("user");
		Log4jUtil.debug(this, "AjaxController from get2 request user:" + user);
		Map<String, Object> data = new HashMap<String, Object>();
		data.putAll(modelMap);
		modelMap.putAll(data);
		modelMap.addAttribute("type", "get2");
		modelMap.addAttribute("result", "true");
		return modelMap.toString();
	}
	
	@RequestMapping(value = "/get3", method = RequestMethod.GET)
	@ResponseBody
	public String get3(String user, ModelMap modelMap) {
		Log4jUtil.debug(this, "AjaxController from get3 request user:" + user);
		Map<String, Object> data = new HashMap<String, Object>();
		data.putAll(modelMap);
		modelMap.putAll(data);
		modelMap.addAttribute("type", "get3");
		modelMap.addAttribute("result", "true");
		return modelMap.toString();
	}
	
	@RequestMapping(value = "/get4", method = RequestMethod.GET)
	@ResponseBody
	public String get4(String user, ModelMap modelMap) {
		Log4jUtil.debug(this, "AjaxController from get4 request user:" + user);
		Map<String, Object> data = new HashMap<String, Object>();
		data.putAll(modelMap);
		modelMap.putAll(data);
		modelMap.addAttribute("type", "get4");
		modelMap.addAttribute("result", "true");
		return modelMap.toString();
	}
	
	
	@RequestMapping(value = "/post1", method = RequestMethod.POST)
	@ResponseBody
	public String post1(ModelMap modelMap) {
		String user = (String)modelMap.get("user");
		Log4jUtil.debug(this, "AjaxController from post1 request user:" + user);
		user = request.getParameter("user");
		Log4jUtil.debug(this, "AjaxController from post1 request user:" + user);
		Map<String, Object> data = new HashMap<String, Object>();
		data.putAll(modelMap);
		modelMap.putAll(data);
		modelMap.addAttribute("type", "post");
		modelMap.addAttribute("result", "post1");
		return modelMap.toString();
	}

	@RequestMapping(value = "/post2", method = RequestMethod.POST)
	@ResponseBody
	public ModelMap post2(@RequestBody ModelMap modelMap) {
		String user = (String)modelMap.get("user");
		Log4jUtil.debug(this, "AjaxController from post2 request user:" + user);
		Map<String, Object> data = new HashMap<String, Object>();
		data.putAll(modelMap);
		modelMap.putAll(data);
		modelMap.addAttribute("type", "post");
		modelMap.addAttribute("result", "post2");
		return modelMap;
	}
	
	
}
