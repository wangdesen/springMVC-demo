package com.demo.springmvc.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface GenericDao<Entity, PK extends Serializable> {

	public Entity findById(PK id);

	public List<Entity> findAll();

	public int findAllCount();

	public List<Entity> findByParameter(Map<String, Object> parameter);

	public int findCountByParameter(Map<String, Object> parameter);

	public boolean save(Entity entity);

	public boolean update(Entity entity);

	public boolean delete(Entity entity);

	public boolean deleteById(PK id);

	public boolean deleteAll(Collection<Entity> entities);

}
