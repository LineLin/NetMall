package com.line.web.model.dao;

import java.util.List;

import com.line.web.model.User;

public interface UserDao extends BasicDao<User>{
	
	
	 User findByAccountAndPsw(String account,String password);
	
	 User findByAccount(String account);
	
	 List<User> all();
	
}
