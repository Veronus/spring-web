package com.mes.test;

import java.io.IOException;
import java.util.List;

import javax.imageio.IIOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mes.dao.UserDao;
import com.mes.meta.User;


public class TestUser {

	public static void main(String[] args) {
		TestUser testUser = new TestUser();
		testUser.check("test1", "test1");
		if (testUser.check("test1", "test1")) {
			System.out.println("login");
		} else {
			System.out.println("username or password error");
		}

	}
	
	public List<User> getUsers() {
		ApplicationContext context = new ClassPathXmlApplicationContext("app.xml");
		UserDao userDao = context.getBean("userDao", UserDao.class);
		List<User> users = userDao.getUserList();
		((ConfigurableApplicationContext) context).close();
		return users;
	}
	
	public boolean check(String userName, String userPassword) {
		ApplicationContext context = new ClassPathXmlApplicationContext("app.xml");
		UserDao userDao = context.getBean("userDao", UserDao.class);
		List<User> users = userDao.getUserList();
		boolean tag = false;
		for (User user : users) {
			if (user.getUserName().equals(userName)  && user.getUserPassword().equals(userPassword)) {
				tag = true;
			}
		}
		((ConfigurableApplicationContext) context).close();
		
		return tag;
	}
	
	
	
/*	@RequestMapping("/user/getHtml")
	public List<User> getHtml(ModelMap map) throws IOException{
		
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		UserDao userDao = context.getBean("userDao", UserDao.class);
		List<User> users = userDao.getUserList();
		
		map.addAttribute("users", users);
		((ConfigurableApplicationContext) context).close();
		
		return users;
	}*/

}
