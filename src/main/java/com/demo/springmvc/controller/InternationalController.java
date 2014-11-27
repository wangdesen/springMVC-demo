package com.demo.springmvc.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.support.RequestContext;

import com.demo.springmvc.model.User;
import com.demo.springmvc.util.Log4jUtil;

/**
 * 
 * @author dreajay
 * 参考：http://www.cnblogs.com/liukemng/p/3750117.html
 *
 */
@Controller
@RequestMapping("/i18n")
public class InternationalController {
	
	/**
	 * 基于请求的国际化实现
	 * @param request
	 * @param response
	 * @param model
	 * @param langType
	 * @return
	 */
	@RequestMapping(value = "/test", method = { RequestMethod.GET })
	public String test(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam(value = "langType", defaultValue = "zh") String langType) {
		Log4jUtil.debug(this, "/i18n/test...");
		if (!model.containsAttribute("user")) {
			// 从后台代码获取国际化信息
			RequestContext requestContext = new RequestContext(request);
			model.addAttribute("username", requestContext.getMessage("username"));
			model.addAttribute("password", requestContext.getMessage("password"));
			User user = new User();
			user.setUsername("李四");
			model.addAttribute("user", user);
		}
		return "i18n";
	}

	/**
	 * 基于session的国际化实现
	 * @param request
	 * @param response
	 * @param model
	 * @param langType
	 * @return
	 */
	@RequestMapping(value = "/session", method = { RequestMethod.GET })
	public String session(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam(value = "langType", defaultValue = "zh") String langType) {
		if (!model.containsAttribute("user")) {
			if (langType.equals("zh")) {
				Locale locale = new Locale("zh", "CN");
				request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, locale);
			} else if (langType.equals("en")) {
				Locale locale = new Locale("en", "US");
				request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, locale);
			} else {
				request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, LocaleContextHolder.getLocale());
			}
			// 从后台代码获取国际化信息
			RequestContext requestContext = new RequestContext(request);
			model.addAttribute("username", requestContext.getMessage("username"));
			model.addAttribute("password", requestContext.getMessage("password"));
			User user = new User();
			user.setUsername("李四");
			model.addAttribute("user", user);
		}
		return "i18n";
	}

	/**
	 * 
	 * 基于cookie的国际化实现
	 * @param request
	 * @param response
	 * @param model
	 * @param langType
	 * @return
	 */
	@RequestMapping(value = "/cookie", method = { RequestMethod.GET })
	public String cookie(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam(value = "langType", defaultValue = "zh") String langType) {
		if (!model.containsAttribute("user")) {
			if (langType.equals("zh")) {
				Locale locale = new Locale("zh", "CN");
				new CookieLocaleResolver().setLocale(request, response, locale);
			} else if (langType.equals("en")) {
				Locale locale = new Locale("en", "US");
				new CookieLocaleResolver().setLocale(request, response, locale);
			} else {
				new CookieLocaleResolver().setLocale(request, response, LocaleContextHolder.getLocale());

			}
			// 从后台代码获取国际化信息
			RequestContext requestContext = new RequestContext(request);
			model.addAttribute("username", requestContext.getMessage("username"));
			model.addAttribute("password", requestContext.getMessage("password"));
			User user = new User();
			user.setUsername("李四");
			model.addAttribute("user", user);
		}
		return "i18n";
	}

}