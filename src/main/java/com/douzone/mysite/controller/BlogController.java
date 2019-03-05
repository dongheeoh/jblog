package com.douzone.mysite.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.douzone.mysite.service.BlogService;
import com.douzone.mysite.vo.BlogVo;

@Controller
@RequestMapping("/blog")
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
	@RequestMapping({"","/main"})
	public String main(Model model, HttpSession session) {
		BlogVo blogVo=blogService.getBlog();
		model.addAttribute("blog",blogVo);
		session.setAttribute("blogTitle", blogVo.getTitle());
		return "/blog/blog-main";
	}
	
	@RequestMapping("/admin")
	public String admin() {
		return "/blog/blog-admin-basic";
	}
	
	@RequestMapping("/category")
	public String category() {
		return "/blog/blog-admin-category";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write() {
		return "/blog/blog-admin-write";
	}
}
