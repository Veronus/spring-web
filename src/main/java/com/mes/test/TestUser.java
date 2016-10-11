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
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("app.xml");
		UserDao userDao = context.getBean("userDao", UserDao.class);
/*		//userDao.creatTable();
		userDao.insertUser(1001,"Veronus");
		userDao.insertUser(1002,"Love caven");
		userDao.insertUser(1003,"Joe");*/
		List<User> users = userDao.getUserList();
		
		System.out.println("_____________________________");
		System.out.println("________"+users+"______________");
		System.out.println("_____________________________");
		
		for (User user : users) {
			System.out.println(user.getUserid()+" name is: "+user.getUsername());
		}
		((ConfigurableApplicationContext) context).close();

	}
	
	public List<User> getUsers() {
		ApplicationContext context = new ClassPathXmlApplicationContext("app.xml");
		UserDao userDao = context.getBean("userDao", UserDao.class);
		List<User> users = userDao.getUserList();
		((ConfigurableApplicationContext) context).close();
		return users;
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
