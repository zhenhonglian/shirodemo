package com.java1234.service.impl;

import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Service;

import com.java1234.dao.UserDao;
import com.java1234.entity.User;
import com.java1234.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Resource
	private UserDao userDao;
	
	public User getByUserName(String userName) {
		return userDao.getByUserName(userName);
	}

	public Set<String> getRoles(String userName) {
		return userDao.getRoles(userName);
	}

	public Set<String> getPermissions(String userName) {
		return userDao.getPermissions(userName);
	}

	public int addUser(String userName, String password) {
		User user=new User();
        String asd=new Md5Hash(password,"lalala").toString();
		user.setUserName(userName);
		user.setPassword(asd);	
		// TODO Auto-generated method stub
		return userDao.insertSelective(user);
	}
	

}
