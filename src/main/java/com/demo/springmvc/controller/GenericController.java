package com.demo.springmvc.controller;

import java.io.Serializable;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.springmvc.service.IGenericService;

public class GenericController<T, PK extends Serializable> {

	IGenericService<T, PK> genericService;

	public IGenericService<T, PK> getGenericService() {
		return genericService;
	}

	public void setGenericService(IGenericService<T, PK> genericService) {
		this.genericService = genericService;
	}

	@RequestMapping(value ="/{id}", method=RequestMethod.POST)
	@ResponseBody
	public T findById(@PathVariable PK id) {
		return genericService.findById(id);
	}
	
	
	@RequestMapping("/save")
	@ResponseBody
	public ModelMap save(@RequestBody T entity, ModelMap modelMap) {
		modelMap.addAttribute("result", genericService.save(entity));
		return modelMap;
	}
	
	@RequestMapping("/update")
	public ModelMap update(@RequestBody T entity, ModelMap modelMap) {
		modelMap.addAttribute("result", genericService.update(entity));
		return modelMap;
	}
	
	@RequestMapping("/delete")
	public ModelMap delete(@RequestBody T entity, ModelMap modelMap) {
		modelMap.addAttribute("result", genericService.delete(entity));
		return modelMap;
	}
	
}
