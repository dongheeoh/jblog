package com.douzone.mysite.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.douzone.dto.JsonResult;
import com.douzone.mysite.service.UserService;

@Controller("userApiController")
@RequestMapping("/user/api")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping("/checkid")
	public JsonResult checkid(@RequestParam(value="id", required=true, defaultValue="")String id) {
		boolean exist=userService.existid(id);
		return JsonResult.success(exist);
	}
}
