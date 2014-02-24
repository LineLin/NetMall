package com.line.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.line.web.model.User;
import com.line.web.model.dao.UserDao;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	public boolean checkFormat(String account,String password){
		
		if(account == null || password == null){
			return false;
		}
		
		account = account.trim();
		password = password.trim();
		
		if(account.isEmpty() || password.isEmpty()){
			return false;
		}
		
		return true;
	}
	
	public User verification(String account,String password){
		
		User user = userDao.findUser(account, password);
		
		return user;
	}
	
	public boolean isUserExist(String account){
		
		User user = userDao.findUserByAccount(account);
		
		if(user == null){
			return false;
		}
		
		return true;
	}
	
}
