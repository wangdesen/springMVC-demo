package com.demo.springmvc.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.demo.springmvc.dao.GenericDao;


public class GenericService<T, PK extends Serializable> implements IGenericService<T, PK> {
	
	
	GenericDao<T, PK> genericDao;
	
	public GenericDao<T, PK> getGenericDao() {
		return genericDao;
	}

	public void setGenericDao(GenericDao<T, PK> genericDao) {
		this.genericDao = genericDao;
	}
	
	@Override
	public T findById(PK id) {
		return genericDao.findById(id);
	}

	@Override
	public List<T> findAll() {
		return genericDao.findAll();
	}

	@Override
	public int findAllCount() {
		return genericDao.findAllCount();
	}

	@Override
	public List<T> findByParameter(Map<String, Object> parameter) {
		return genericDao.findByParameter(parameter);
	}

	@Override
	public int findCountByParameter(Map<String, Object> parameter) {
		return genericDao.findCountByParameter(parameter);
	}

	@Override
	public boolean save(T entity) {
		return genericDao.save(entity);
	}
	public boolean update(T entity) {
		return genericDao.update(entity);
	}

	public boolean delete(T entity) {
		return genericDao.delete(entity);
	}

	public boolean deleteById(PK id){
		return genericDao.deleteById(id);
	}

	public boolean deleteAll(Collection<T> entities) {
		return genericDao.deleteAll(entities);
	}
	
}
