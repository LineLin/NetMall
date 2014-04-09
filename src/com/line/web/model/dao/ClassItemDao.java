package com.line.web.model.dao;

import java.util.List;

import com.line.web.model.ClassItem;

public interface ClassItemDao extends BasicDao<ClassItem>{
	
	List<ClassItem> getAll();
	
}
