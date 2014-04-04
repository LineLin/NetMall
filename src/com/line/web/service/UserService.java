package com.line.web.service;

import com.line.web.model.User;

public interface UserService {
	
	public boolean checkFormat(String account,String password);
	
	public User verification(String account,String password);
	
	public boolean isUserExist(String account);
	
	public User saveUser(String account,String password);
	
	public User findUserById(String userId);

}
