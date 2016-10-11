package com.netease.course.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mes.test.TestBlog;

import org.springframework.ui.ModelMap;

@Controller
public class AddBlog {
	@RequestMapping("/blog/addblog")
	public String addblog(String retHtml,@RequestParam("blogTitle") String blogTitle, @RequestParam("blogContent")String blogContent, ModelMap map) {
		if (blogTitle.length() > 20 || blogContent.length() > 200) {
			retHtml = "400";
		}else {
			TestBlog testBlog = new TestBlog();
			testBlog.addblog(blogTitle, blogContent);
			map.addAttribute("blogtitle", blogTitle);
			map.addAttribute("blogcontent", blogContent);
			retHtml = "";
		}
		
		return retHtml;
	}
}
