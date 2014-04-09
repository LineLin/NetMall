package com.line.web.model.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("unchecked")
public class BasicDaoImpl<T> implements BasicDao<T>{
	
	@Autowired
	protected SessionFactory sf;
	
	@Override
	public void save(T obj){
		getSession().save(obj);
	}
	
	@Override
	public void update(T obj){
		getSession().update(obj);
	}
	
	@Override
	public void delete(T obj){
		getSession().delete(obj);
	}
	
	@Override
	public T findById(String id,Class<T> clz){
		return (T) getSession().get(clz, id);
	}
	
	@Override
	public Session getSession(){
		return sf.getCurrentSession();
	}
}
