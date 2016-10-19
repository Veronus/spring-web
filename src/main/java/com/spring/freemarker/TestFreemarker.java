package com.spring.freemarker;

import java.io.IOException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mes.dao.UserDao;
import com.mes.meta.User;

@Controller
public class TestFreemarker {
	@RequestMapping("/users/login")
	public String login(@RequestParam("userId1") String userId1, @RequestParam("userName1") String userName1,
			@RequestParam("userId2") String userId2, @RequestParam("userName2") String userName2, ModelMap map)
			throws IOException {
		map.addAttribute("userId1", userId1);
		map.addAttribute("userName1", userName1);
		map.addAttribute("userId2", userId2);
		map.addAttribute("userName2", userName2);
		
/*		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		UserDao userDao = context.getBean("userDao", UserDao.class);
		List<User> users = userDao.getUserList();
	
		for (User user : users) {
			System.out.println(user.getUserid()+user.getUsername());
		}
		
		((ConfigurableApplicationContext) context).close();*/

		return "user";
	}
	
	@RequestMapping("/users/getHtml")
	public String getHtml(ModelMap map) throws IOException{
		
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		UserDao userDao = context.getBean("userDao", UserDao.class);
		List<User> users = userDao.getUserList();
		
		map.addAttribute("users", users);
		for (User user : users) {
			System.out.println(user.getUserName()+user.getUserPassword());
		}
		
		((ConfigurableApplicationContext) context).close();
		
		return "users";
	}
}
