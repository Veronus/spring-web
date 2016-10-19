package com.netease.course.web.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mes.test.TestBlog;

import org.springframework.ui.ModelMap;

@Controller
public class AddBlog {
	@RequestMapping("/blog/addblogSpring")
	public String addblog(String retHtml,@RequestParam("blogTitle") String blogTitle, @RequestParam("blogContent")String blogContent,@RequestBody String body,
            HttpServletRequest request, HttpServletResponse response, ModelMap map) {
		System.out.println(blogTitle+"----"+blogContent);
		if (blogTitle.length() > 20 || blogContent.length() > 200) {
			System.out.println("reture 400");
			 response.setStatus(400);
			 return "博客长度过长";
		}else {
			System.out.println("reture 200");
			response.setStatus(200);
			TestBlog testBlog = new TestBlog();
			testBlog.addblog(blogTitle, blogContent);
			map.addAttribute("blogtitle", blogTitle);
			map.addAttribute("blogcontent", blogContent);
			return "blog";
		}
	}
}
