package com.douzone.mysite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.mysite.repository.UserDao;
import com.douzone.mysite.vo.UserVo;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	public boolean existid( String id ) {
		UserVo userVo = userDao.get( id );
		return userVo != null;
	}
	
	public void join( UserVo userVo ,String logo) {
		userDao.insert( userVo,logo );
	}
	
	public UserVo getUser( String id, String password ) {
		System.out.println(userDao.get(id,password));
		return userDao.get( id, password );
	}
}
