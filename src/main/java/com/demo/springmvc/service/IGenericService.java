package com.demo.springmvc.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface IGenericService<T, PK extends Serializable> {

	public T findById(PK id);

	public List<T> findAll();

	public int findAllCount();

	public List<T> findByParameter(Map<String, Object> parameter);

	public int findCountByParameter(Map<String, Object> parameter);

	public boolean save(T entity);

	public boolean update(T entity);

	public boolean delete(T entity);

	public boolean deleteById(PK id);

	public boolean deleteAll(Collection<T> entities);
}
