package com.douzone.mysite.repository;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.mysite.vo.BlogVo;

@Repository
public class BlogDao {
	@Autowired
	private SqlSession sqlSession;
	
	public long get(String id) {
		return sqlSession.selectOne("blog.getId", id);
	}
	
	public BlogVo get(long no) {
		return sqlSession.selectOne("blog.getNo", no);
	}
	public int updateAdminBasicInfo(Map<String, Object> map)
	{
		return sqlSession.update("blog.updateAdminBasicInfo", map);
	}

}
