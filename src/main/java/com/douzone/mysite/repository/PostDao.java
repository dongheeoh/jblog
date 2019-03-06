package com.douzone.mysite.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.mysite.vo.PostVo;

@Repository
public class PostDao {

	@Autowired
	private SqlSession sqlSession;
	
	public PostVo get(long userNo,long categoryNo, long postNo) {
		
		Map<String, Long> map = new HashMap<String, Long>();
		map.put( "userNo", userNo );
		map.put( "categoryNo", categoryNo );
		map.put( "postNo", postNo );
		
		return sqlSession.selectOne("blog.getPost", map);
	}
	
	public List<PostVo> getList(long userNo,long categoryNo){
		Map<String, Long> map = new HashMap<String, Long>();
		map.put( "userNo", userNo );
		map.put( "categoryNo", categoryNo );
		
		return sqlSession.selectList("blog.getPostList",map);
	}
	
	public int postWrite(Map<String, Object> map)
	{
		return sqlSession.insert("blog.postWrite", map);
	}
}
