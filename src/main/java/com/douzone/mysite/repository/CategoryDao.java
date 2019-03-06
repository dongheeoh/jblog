package com.douzone.mysite.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.mysite.vo.CategoryVo;

@Repository
public class CategoryDao {
	@Autowired
	private SqlSession sqlSession;
	
	public List<CategoryVo> getList(long userNo){
		return sqlSession.selectList("blog.getUserNo", userNo);
	}
	
	public long setCategory(Map<String, Object> map)
	{
		sqlSession.insert("blog.setCategory", map);
		
		return (long) map.get("no");
	}
	
	public void categoryDelete(Map<String, Object> map)
	{
		sqlSession.delete("blog.categoryDelete", map);
	}
	
}
