package com.line.web.model.dao;

import java.lang.reflect.ParameterizedType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unchecked")
abstract class BasicDaoImpl<T> implements BasicDao<T>{
	
	public Class<T> clz;
	
	public BasicDaoImpl(){
		clz =(Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
	}
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
	public T getById(String id){
		return (T) getSession().get(clz, id);
	}
	
	@Override
	public Session getSession(){
		return sf.getCurrentSession();
	}
}
