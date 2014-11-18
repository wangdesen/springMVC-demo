package com.demo.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;

public class Context {

	HttpServletRequest request;
	HttpServletResponse response;
	HttpSession session;

	// 1)放置在方法的形参上：表示引用Model中的数据
	// 2)放置在方法上面：表示请求该类的每个Action前都会首先执行它，你可以将一些准备数据的操作放置在该方法里面。
	@ModelAttribute
	public void setContext(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.session = request.getSession();
	}

	public String getServerPath() {
		return session.getServletContext().getRealPath("");
	}

	public String getRealyPath(String path) {
		return session.getServletContext().getRealPath(path);
	}

}
