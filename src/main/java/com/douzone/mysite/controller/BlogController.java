package com.douzone.mysite.controller;


import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.douzone.dto.JsonResult;
import com.douzone.mysite.service.BlogService;
import com.douzone.mysite.service.FileuploadService;
import com.douzone.mysite.vo.BlogVo;
import com.douzone.mysite.vo.CategoryVo;
import com.douzone.mysite.vo.UserVo;
import com.douzone.security.AuthUser;


@Controller
@RequestMapping("/{id:(?!assets).*}")
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	@Autowired
	private FileuploadService fileuploadService;
	
	@RequestMapping(value={"","/{pathNo1}","/{pathNo1}/{pathNo2}"})
	public String main(@PathVariable("id") String id,
					   @PathVariable Optional<Long> pathNo1,
					   @PathVariable Optional<Long> pathNo2,
					   Model model){
		
		long categoryNo = 1;
		long postNo = 1;
		System.out.println("========+++++========"+id);
		if(!(pathNo1.toString() == "Optional.empty")) {
			categoryNo = pathNo1.get();
		}
		if(!(pathNo2.toString() == "Optional.empty")) {
			postNo = pathNo2.get();
		}
		
		Map<String, Object> blogMain;
		blogMain = blogService.getAll(id, categoryNo, postNo);
		
		model.addAttribute("userId", id);
		model.addAttribute("blogVo",blogMain.get("blogVo"));
		model.addAttribute("categoryList",blogMain.get("categoryList"));
		model.addAttribute("postVo",blogMain.get("postVo"));
		model.addAttribute("postList",blogMain.get("postList"));
		
		return "/blog/blog-main";			
	}
//===================================getList===============
	
	@RequestMapping(value="/admin" , method=RequestMethod.GET)
	public String admin(@PathVariable("id") String id,@ModelAttribute BlogVo blogVo, Model model) {
		
		System.out.println("=*=*=*=*=*=*=>"+id);
		blogVo = blogService.getAdmin(id);
		model.addAttribute("blogVo", blogVo );
		
		return "/blog/blog-admin-basic";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.POST)
	public String admin(@RequestParam(value = "logo-file") MultipartFile multipartFile, 
						@AuthUser UserVo userVo, Model model,
						@ModelAttribute @Valid BlogVo blogVo, 
						BindingResult result) 
	{

		String imgUrl = fileuploadService.restore(multipartFile);
		System.out.println("1231121>>>>"+userVo);
		if (result.hasErrors()) {
			
			model.addAllAttributes(result.getModel());
			model.addAttribute("blogVo", blogService.getBlog(userVo.getNo()));
			return "/blog/blog-admin-basic";
		}


		System.out.println("imgUrl : " + imgUrl);
		
		if( imgUrl.equals("") == true) 
		{
			imgUrl = null;
		}
		
		blogVo.setLogo(imgUrl);
		System.out.println("+-=-=-=-=-=-+-=-=="+userVo.getNo());
		blogService.updateAdminBasicInfo(blogVo, userVo.getNo());

		model.addAttribute("blogVo", blogVo);
		

		return "redirect:/" + userVo.getId();
	}
	
	//================================admin======================
	
	@RequestMapping(value = "/admin/category", method = RequestMethod.GET)
	public String adminCategory(@AuthUser UserVo userVo,
								Model model) 
	{
		BlogVo blogVo = blogService.getBlog(userVo.getNo());
		List<CategoryVo> categoryList = blogService.getCategoryList(userVo.getNo());
		
		System.out.println("blogVo : " + blogVo);
		model.addAttribute("blogVo", blogVo);
		model.addAttribute("categoryList", categoryList);
		
		return "/blog/blog-admin-category";
	}
	
	@ResponseBody
	@RequestMapping(value = "/admin/category/ajax", method = RequestMethod.GET)
	public JsonResult putshAjaxCategoryList(@AuthUser UserVo userVo)
	{
		System.out.println("여기오나요?");
		List<CategoryVo> categoryList = blogService.getCategoryList(userVo.getNo());
		
		System.out.println("categoryList : " + categoryList);
		return JsonResult.success(categoryList);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/admin/category", method = RequestMethod.POST)
	public JsonResult adminCategoryAdd(@ModelAttribute @Valid CategoryVo categoryVo,
								 @AuthUser UserVo userVo,
								 BindingResult result,
								 Model model)
	{
		System.out.println("categoryVo : " + categoryVo);
		
		if( result.hasErrors())
		{
			model.addAllAttributes( result.getModel());
			return JsonResult.fail("실패");
		}
		
		long results = blogService.setCategory(categoryVo, userVo.getNo());
		System.out.println("results : " + results);
		
		categoryVo.setNo(results);
		return JsonResult.success(categoryVo);
	}
	
	@ResponseBody
	@RequestMapping(value = "/admin/category/delete/{no}", method = RequestMethod.GET)
	public JsonResult adminCategoryDelete(@ModelAttribute CategoryVo categoryVo,
										  @AuthUser UserVo userVo)
	{		
		blogService.categoryDelete(userVo.getNo(), categoryVo.getNo());
		return JsonResult.success(categoryVo.getNo());
	}
	//================================category==========================================
	
	@RequestMapping(value = "/admin/write", method = RequestMethod.POST)
	public String adminWrite(Model model, 
							@AuthUser UserVo userVo, 
							@RequestParam("category") String categoryName,
							@ModelAttribute @Valid BlogVo blogVo,
							BindingResult result) 
	{
		if (result.hasErrors()) {
			model.addAllAttributes(result.getModel());
			blogVo = blogService.getBlog(userVo.getNo());
			List<CategoryVo> categoryList = blogService.getCategoryName(userVo.getNo());

			model.addAttribute("blogVo", blogVo);
			model.addAttribute("categoryList", categoryList);
			
			return "/blog/blog-admin-write";
		} 
		else 
		{
			int results = blogService.postWrite(categoryName, blogVo, userVo.getNo());
		}

		return "redirect:/" + userVo.getId() + "/admin/write";
	}
}
