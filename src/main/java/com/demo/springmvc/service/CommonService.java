package com.demo.springmvc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.springmvc.model.Book;
import com.demo.springmvc.model.User;

@Service("commonService")
public class CommonService {
	
	Logger logger = LoggerFactory.getLogger(CommonService.class);

	@Autowired
	private UserService userService;
	
	@Autowired
	private BookService bookService;
	
	public boolean AddMethod(int id){
		User user = userService.findById(1);
		Book book = bookService.findById(1);
		
		user.setUserId(id);
		Boolean addUserStatus = userService.AddUser(user);
		logger.info("status:{}", addUserStatus);
		book.setId(id);
		book.setUserId(""+id);
		Boolean addBookStatus = bookService.AddBookUser(book);
		logger.info("status:{}", addBookStatus);
		
		return true;
	}
	
}
