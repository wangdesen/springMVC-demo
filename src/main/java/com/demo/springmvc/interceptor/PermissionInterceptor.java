package com.demo.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.demo.springmvc.util.Log4jUtil;

/**
 * 实现HandlerInterceptor
 * @author dreajay
 *
 */
public class PermissionInterceptor  implements HandlerInterceptor {

	/**
	 * preHandle方法在执行控制器之前执行
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Log4jUtil.debug(this, "LoginInterceptor preHandle...");
		//return false;//将不会执行控制器
		return true;
	}

	/**
	 * postHandle方法在执行控制器返回ModelAndView，但未进行页面渲染之前执行，在这可以修改ModelAndView
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		Log4jUtil.debug(this, "PermissionInterceptor postHandle...");
		//处理自己的逻辑
		if(Boolean.FALSE) {
			modelAndView.setViewName("login");
		}
	}

	/**
	 * afterCompletion方法在返回结果页面并已经渲染完时执行，一般用来做清理工作
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		Log4jUtil.debug(this, "LoginInterceptor afterCompletion...");
	}

}
