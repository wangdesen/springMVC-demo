package com.demo.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.springmvc.exception.ControllerException;
import com.demo.springmvc.exception.GlobalException;
import com.demo.springmvc.util.Log4jUtil;

@Controller
@RequestMapping("/exception")
public class ExceptionController {

	@RequestMapping("/normal")
	public ModelAndView normal(ModelAndView modelAndView) throws Exception {
		if(Boolean.TRUE) {
			throw new Exception("ExceptionController throw a java.lang.Exception");
		}
		modelAndView.setViewName("success");
		return modelAndView;
	}
	
	@RequestMapping("/global")
	public ModelAndView local(ModelAndView modelAndView) throws Exception {
		if(Boolean.TRUE) {
			throw new GlobalException("ExceptionController throw a com.demo.springmvc.exception.GlobalException");
		}
		modelAndView.setViewName("success");
		return modelAndView;
	}
	
	@RequestMapping("/custom")
	public ModelAndView custom(ModelAndView modelAndView) throws Exception {
		if(Boolean.TRUE) {
			throw new ControllerException("ExceptionController throw a com.demo.springmvc.exception.ControllerException");
		}
		modelAndView.setViewName("success");
		return modelAndView;
	}
	
	
	/**
	 * 局部异常处理,仅仅只能处理这个控制器中的异常，可以在基类中实现，子类都继承
	 */
	@ExceptionHandler(value={ControllerException.class})
	public String handlerException(ControllerException e, HttpServletRequest req) {
		Log4jUtil.debug(this, "ExceptionController catch the ControllerException...");
		req.setAttribute("exception", e);
		return "error";
	}
	
}
