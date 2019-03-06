package com.douzone.mysite.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.mysite.repository.BlogDao;
import com.douzone.mysite.repository.CategoryDao;
import com.douzone.mysite.repository.PostDao;
import com.douzone.mysite.vo.BlogVo;
import com.douzone.mysite.vo.CategoryVo;
import com.douzone.mysite.vo.PostVo;

@Service
public class BlogService {
	@Autowired
	private BlogDao blogDao;
	@Autowired
	private PostDao postDao;
	@Autowired
	private CategoryDao categoryDao;
	
	public Map<String,Object> getAll(String id,Long categoryNo,Long postNo){
		
		long userNo=blogDao.get(id);
		
		BlogVo blogVo=blogDao.get(userNo);
		
		List<CategoryVo> categoryList= categoryDao.getList(userNo);

		PostVo postVo = postDao.get(userNo, categoryNo, postNo);

		List<PostVo> postList = postDao.getList(userNo, categoryNo);
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("blogVo", blogVo);
		map.put("categoryList", categoryList);
		map.put("postVo", postVo);
		map.put("postList", postList);
				
		return map;
	}
	
	public BlogVo getAdmin(String id) {
		long userNo = blogDao.get(id);
		return blogDao.get(userNo);
	}
	public List<CategoryVo> getcategory(String id) {
		long userNo = blogDao.get(id);
		return categoryDao.getList(userNo);
	}
	
	public int updateAdminBasicInfo(BlogVo blogVo, long userNo)
	{
		Map<String, Object> map = new HashMap<>();
		map.put("blogVo", blogVo);
		map.put("userNo", userNo);
		
		return blogDao.updateAdminBasicInfo(map);
	}
	
	public BlogVo getBlog(long userNo)
	{
		return blogDao.get(userNo);
	}
	
	public List<CategoryVo> getCategoryName(long userNo)
	{
		return categoryDao.getList(userNo);
	}
	
	public int postWrite(String categoryName, BlogVo blogVo, long userNo)
	{
		Map<String, Object> map = new HashMap<>();
		map.put("blogVo", blogVo);
		map.put("categoryName", categoryName);
		map.put("userNo", userNo);
				
		return postDao.postWrite(map);
	}
	
	public List<CategoryVo> getCategoryList(long userNo)
	{
		return categoryDao.getList(userNo);
	}
	
	public long setCategory(CategoryVo categoryVo, long userNo)
	{
		Map<String, Object> map = new HashMap<>();
		map.put("categoryVo", categoryVo);
		map.put("userNo", userNo);
		
		return categoryDao.setCategory(map);
	}
	
	public void categoryDelete(long userNo, long categoryNo)
	{
		Map<String, Object> map = new HashMap<>();
		map.put("categoryNo", categoryNo);
		map.put("userNo", userNo);
		
		categoryDao.categoryDelete(map);
	}
}
