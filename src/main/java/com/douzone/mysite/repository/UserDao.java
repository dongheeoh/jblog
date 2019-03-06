package com.douzone.mysite.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.mysite.exception.UserDaoException;
import com.douzone.mysite.vo.UserVo;

@Repository
public class UserDao {

	@Autowired
	private SqlSession sqlSession;
	
	public UserVo get( String id ) {
		
		return sqlSession.selectOne( "user.getByid", id );
	}
	
	public void insert( UserVo userVo ,String logo) {
		sqlSession.insert( "user.insert", userVo );
		String title=sqlSession.selectOne("user.getId", userVo.getNo())+"님의 블로그 입니다.";
		
		Map<String, Object> map = new HashMap<>();
		map.put("userNo", userVo.getNo());
		map.put("title", title);
		map.put("logo",logo);
		map.put("defaultCategoryName","미분류");
		map.put("defaultCategoryDescription","기본 카테고리 입니다.");
		
		sqlSession.insert("user.insertBlog", map);
		sqlSession.insert("user.insertDefaultCategory", map);
	}
	
	public UserVo get( String id, String password )  throws UserDaoException {
		Map<String, String> map = new HashMap<String, String>();
		map.put( "id", id );
		map.put( "password", password );
		
		return sqlSession.selectOne( "user.getByidAndPassword", map );
	}
}
