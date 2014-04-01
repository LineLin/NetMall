package com.line.web.model.dao;

import java.util.List;

import com.line.web.model.User;

public interface UserDao extends BasicDao<User>{
	
	
	public User findByAccountAndPsw(String account,String password);
	
	public User findByAccount(String account);
	
	public List<User> all();
	
}
