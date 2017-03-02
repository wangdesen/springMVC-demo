package com.demo.springmvc.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.demo.springmvc.model.Book;
import com.demo.springmvc.model.User;
import com.demo.springmvc.util.Log4jUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:springMVC.xml"})
public class UserServiceTest extends AbstractJUnit4SpringContextTests {
	
	Logger logger = LoggerFactory.getLogger(UserServiceTest.class);
	
	@Autowired
	UserService userService;
	
	@Autowired
	BookService bookService;
	
	@Autowired
	private CommonService commonService;
	
	@Test
	public void testFindById() {
		
		User user = userService.findById(1);
		Book book = bookService.findById(1);
		
		logger.info("userService.findById(1) result:{}", user);
		logger.info("bookService.findById(1) result:{}", book);
		
		//Log4jUtil.debug(this, "userService.findById(1) result: " + user);
	}
	
	@Test
	public void testAddMethod() {
		for(int i = 1 ; i < 5 ; i ++){
			logger.info("进行到了第{}步！", i);
			try {
				commonService.AddMethod(i);
			} catch (RuntimeException e) {
				// TODO: handle exception
				continue;
			}
			
		}
	}

}
