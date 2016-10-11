package com.netease.course.web.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mes.dao.BlogDao;

import freemarker.ext.beans.MapModel;

@Controller
public class AddBlog {
	@RequestMapping("/blog/addblog")
	public String addblog(String retHtml,@RequestParam("blogTitle") String blogTitle, @RequestParam("blogContent")String blogContent, MapModel mapModel) {
		if (blogTitle.length() > 20 || blogContent.length() > 200) {
			retHtml = "400";
		}else {
			ApplicationContext context = new ClassPathXmlApplicationContext("app.xml");
			BlogDao blogDao = context.getBean("blogDao", BlogDao.class);
			((ConfigurableApplicationContext) context).close();
		}
		
		return retHtml;
	}
}
