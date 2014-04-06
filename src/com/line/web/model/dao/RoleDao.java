package com.line.web.model.dao;

import java.util.List;

import com.line.web.model.Role;

public interface RoleDao extends BasicDao<Role> {
	
	 List<Role> getAllRoles();
	
	 Role getById(String id);
	
	 Role getByName(String name);
	
}
