package com.demo.springmvc.controller;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.springmvc.model.User;
import com.demo.springmvc.util.Log4jUtil;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:springMVC.xml"})
public class UserControllerTest {


	@Resource(name="userController")
	UserController userController;
	
	@Test
	public void testFindById() {
		User user = userController.findById(1);
		Log4jUtil.debug(this, "userController.findById(1) result: " + user);
	}
}
