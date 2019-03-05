package com.douzone.mysite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.mysite.repository.BlogDao;
import com.douzone.mysite.vo.BlogVo;



@Service
public class BlogService {

	@Autowired
	private BlogDao blogDao;
	
	public BlogVo getBlog() {
		return blogDao.getBlog();
	}
}
