package com.demo.springmvc.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.demo.springmvc.dao.GenericDao;
import com.demo.springmvc.model.Book;

@Service("bookService")
public class BookService extends GenericService<Book, Integer> {

	@Resource(name="bookDao")
	public void setGenericDao(GenericDao<Book, Integer> genericDao) {
		this.genericDao = genericDao;
	}
	
	public boolean AddBookUser(Book book){
		
		this.genericDao.save(book);	
		if (book.getId()==3) {
			throw new RuntimeException();
		}
		return true;
		//throw new RuntimeException();
	}
	
}
