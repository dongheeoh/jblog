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
	
	public int insert( UserVo userVo ) {
		return sqlSession.insert( "user.insert", userVo );
	}
	
	public UserVo get( String id, String password )  throws UserDaoException {
		Map<String, String> map = new HashMap<String, String>();
		map.put( "id", id );
		map.put( "password", password );
		
		return sqlSession.selectOne( "user.getByidAndPassword", map );
	}
}
