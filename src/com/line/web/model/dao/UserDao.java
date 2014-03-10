package com.line.web.model.dao;

import java.util.List;

import com.line.web.model.User;

public interface UserDao {
	
	
	public User findByAccountAndPsw(String account,String password);
	
	public User findByAccount(String account);
	
	public void save(User user);
	
	public List<User> all();
	
	public void updata(User user);
}
