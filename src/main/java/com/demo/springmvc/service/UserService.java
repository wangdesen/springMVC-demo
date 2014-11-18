package com.demo.springmvc.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.demo.springmvc.dao.GenericDao;
import com.demo.springmvc.model.User;

@Service("userService")
public class UserService extends GenericService<User, Integer> {

	@Resource(name="userDao")
	public void setGenericDao(GenericDao<User, Integer> genericDao) {
		this.genericDao = genericDao;
	}
	
}
