package com.demo.springmvc.dao;

import org.springframework.stereotype.Repository;

import com.demo.springmvc.model.Book;

@Repository
public interface BookDao extends GenericDao<Book, Integer> {
}
