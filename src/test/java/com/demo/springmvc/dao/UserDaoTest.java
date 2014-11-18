package com.demo.springmvc.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.springmvc.model.User;
import com.demo.springmvc.util.Log4jUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:springMVC.xml"})
public class UserDaoTest extends AbstractJUnit4SpringContextTests {
	@Resource
	UserDao userDao;
	
	@Test
	public void testFindById() {
		User user = userDao.findById(1);
		Log4jUtil.debug(this, "userDao.findById(1): " + user);
	}

}
