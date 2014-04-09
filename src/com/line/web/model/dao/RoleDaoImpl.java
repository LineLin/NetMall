package com.line.web.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.line.web.model.Role;

@Repository
@SuppressWarnings("unchecked")
public class RoleDaoImpl extends BasicDaoImpl<Role> implements RoleDao {


	
	@Override
	public List<Role> getAllRoles() {
		return getSession().createQuery("from Role r").list();
	}

	@Override
	public Role getById(String id) {
		return (Role)getSession().get(Role.class, id);
	}

	@Override
	public Role getByName(String name) {
		return (Role)getSession().createQuery("from Role r where r.name = :name")
				.setParameter("name",name)
				.uniqueResult();
	}

}
