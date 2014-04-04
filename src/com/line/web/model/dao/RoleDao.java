package com.line.web.model.dao;

import java.util.List;

import com.line.web.model.Role;

public interface RoleDao extends BasicDao<Role> {
	
	public List<Role> getAllRoles();
	
	public Role getById(String id);
	
	public Role getByName(String name);
	
}
