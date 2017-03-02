package com.demo.springmvc.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.demo.springmvc.dao.GenericDao;
import com.demo.springmvc.model.User;

@Service("userService")
public class UserService extends GenericService<User, Integer> {

	Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Resource(name="userDao")
	public void setGenericDao(GenericDao<User, Integer> genericDao) {
		this.genericDao = genericDao;
	}
	
	public boolean AddUser(User user){
		try {
			this.genericDao.save(user);
		} catch (RuntimeException e) {
			logger.error(e.getMessage());
			throw new RuntimeException();
		}
		return true;
		
	}
	
}
