package com.line.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.line.web.model.Role;
import com.line.web.model.User;
import com.line.web.model.dao.RoleDao;
import com.line.web.model.dao.UserDao;
import com.line.web.utils.enumtool.RoleEnum;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;
	
	/**
	 * 功能：检查账户和密码是否符合格式
	 */
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
	
	/**
	 *	功能：登陆验证
	 */
	public User verification(String account,String password){
		
		User user = userDao.findByAccountAndPsw(account, password);
		
		return user;
	}
	
	/**
	 * @param account 账号
	 * 功能：检查账号是否已存在
	 */
	
	public boolean isUserExist(String account){
		User user = userDao.findByAccount(account);
		
		if(user == null){
			return false;
		}
		
		return true;
	}
	
	/**
	 * 功能：添加用户到数据库
	 * @param account 账户
	 * @param password 密码
	 */
	@Override
	public User saveUser(String account,String password){
		
		User user = new User(account,password);
		Role role = roleDao.getByName(RoleEnum.BUYER.getName()); 
		user.addRole(role);
		userDao.save(user);
		return user;
	}
	
	@Override
	public User findUserById(String userId){
		return userDao.findById(userId, User.class);
	}
}
