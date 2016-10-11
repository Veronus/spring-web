package com.netease.course.web.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mes.dao.UserDao;
import com.mes.meta.User;
import com.mes.test.TestUser;

@Controller
public class HelloController {

	@RequestMapping("/users/{userId}")
	public void spring(@PathVariable("userId") String userId, @RequestParam("msg") String msg,
			@RequestHeader("host") String host, Writer writer) throws IOException {
		writer.write("userId=" + userId + ", msg=" + msg + ", hostHeader=" + host);
	}

	@RequestMapping("/users/login")
	public String login(@RequestParam("name") String name, @RequestParam("password") String password, ModelMap map)
			throws IOException {
		map.addAttribute("name", name);
		map.addAttribute("password", "******");

		return "user";
	}
	
	@RequestMapping("/users/getHtml")
	public String getHtml(@RequestParam("return")String retHtml,ModelMap map) throws IOException{
		TestUser testUser = new TestUser();
		List<User> users = testUser.getUsers();
		for (User user : users) {

			if (user.getUserid() == 1001) {
				map.addAttribute("userid1", user.getUserid());
				map.addAttribute("username1", user.getUsername());
				
			}else if (user.getUserid() == 1002) {
				map.addAttribute("userid2", user.getUserid());
				map.addAttribute("username2", user.getUsername());
			}else if (user.getUserid() == 1003) {
				map.addAttribute("userid3", user.getUserid());
				map.addAttribute("username3", user.getUsername());
			}
		}
		
		return retHtml;
	}
	
	
	@RequestMapping("/users/getJson")
	public String getJson(ModelMap map,String json) throws IOException{
		TestUser testUser = new TestUser();
		List<User> users = testUser.getUsers();

		
		for (User user : users) {

			if (user.getUserid() == 1001) {
				map.addAttribute("userid1", user.getUserid());
				map.addAttribute("username1", user.getUsername());
				
			}else if (user.getUserid() == 1002) {
				map.addAttribute("userid2", user.getUserid());
				map.addAttribute("username2", user.getUsername());
			}else if (user.getUserid() == 1003) {
				map.addAttribute("userid3", user.getUserid());
				map.addAttribute("username3", user.getUsername());
			}
	
		}
		json ="";
		return json;
	}
}
