package com.demo.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.demo.springmvc.util.Log4jUtil;

/**
 * 全局拦截器
 * @author dreajay
 *
 */
public class GlobalInterceptor extends HandlerInterceptorAdapter {

	/**
	 * preHandle方法在执行控制器之前执行
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Log4jUtil.debug(this, "GlobalInterceptor preHandle...");
		return super.preHandle(request, response, handler);
	}

	/**
	 * postHandle方法在执行控制器返回ModelAndView，但未进行页面渲染之前执行，在这可以修改ModelAndView
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		Log4jUtil.debug(this, "GlobalInterceptor postHandle...");
		super.postHandle(request, response, handler, modelAndView);
	}

	/**
	 * afterCompletion方法在返回结果页面并已经渲染完时执行，一般用来做清理工作
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		Log4jUtil.debug(this, "GlobalInterceptor afterCompletion...");
		super.afterCompletion(request, response, handler, ex);
	}

}
