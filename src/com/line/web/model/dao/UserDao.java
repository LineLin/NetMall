package com.line.web.model.dao;

import java.util.List;

import com.line.web.model.User;

public interface UserDao {
	
	
	public User findUser(String account,String password);
	
	public User findUserByAccount(String account);
	
	public void saveUser(User user);
	
	public List<User> allUser();
	
	public void updataUserImfo(User user);
}
