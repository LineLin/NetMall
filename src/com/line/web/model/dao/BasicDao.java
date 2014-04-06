package com.line.web.model.dao;

public interface BasicDao<T> {
	
	 void save(T obj);
	
	 void update(T obj);
	
	 void delete(T obj);
	
	 T findById(String id,Class<T> clz);

}
