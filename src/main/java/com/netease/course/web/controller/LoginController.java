package com.netease.course.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mes.test.TestUser;

@Controller
public class LoginController {
	
	@RequestMapping("/edit/{userid}")
	public String login(@PathVariable("userid")String userid,@RequestParam("userName")String userName,
			@RequestParam("userPassword")String userPassword,ModelMap map) {
		userid = userName;
		TestUser testUser = new TestUser();
		map.addAttribute("userName", userName);
		map.addAttribute("userPassword", userPassword);
		if (testUser.check(userName, userPassword)) {
			System.out.println("login");
			return "edit";
		}else {
			System.out.println("some error");
			return "error";
		}
	}
}
