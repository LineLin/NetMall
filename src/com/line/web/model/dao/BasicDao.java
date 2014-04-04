package com.line.web.model.dao;

public interface BasicDao<T> {
	
	public void save(T obj);
	
	public void update(T obj);
	
	public void delete(T obj);
	
	public T findById(String id,Class<T> clz);

}
