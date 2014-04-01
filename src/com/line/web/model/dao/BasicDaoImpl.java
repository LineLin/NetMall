package com.line.web.model.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BasicDaoImpl<T> implements BasicDao<T>{
	
	@Autowired
	protected SessionFactory sf;
	
	public void save(T obj){
		sf.getCurrentSession().save(obj);
	}
	
	public void update(T obj){
		sf.getCurrentSession().update(obj);
	}
	
	public void delete(T obj){
		sf.getCurrentSession().delete(obj);
	}
}
