package com.demo.springmvc.dao;

import org.springframework.stereotype.Repository;

import com.demo.springmvc.model.User;

@Repository
public interface UserDao extends GenericDao<User, Integer> {
}
