package com.line.web.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.line.web.model.ClassItem;

@SuppressWarnings("unchecked")
@Repository
public class ClassItemDaoImpl extends BasicDaoImpl<ClassItem> implements
		ClassItemDao {
	
	@Override
	public List<ClassItem> getAll() {
		return getSession().createQuery("from ClassItem c").list();
	}

}
