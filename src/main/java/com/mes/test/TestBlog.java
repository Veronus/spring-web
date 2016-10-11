package com.mes.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestParam;

import com.mes.dao.BlogDao;
import com.mes.meta.Blog;

public class TestBlog {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("app.xml");
		BlogDao blogDao = context.getBean("blogDao", BlogDao.class);
		/*blogDao.addBlog("wodxi1", "111111=111");
		blogDao.addBlog("wofxi2", "11121111111111111");
		blogDao.addBlog("wossxi3", "111111111111111");
		blogDao.addBlog("woxfi4", "11111111111111");
		blogDao.addBlog("wosfxi6", "1111711111111");*/
		List<Blog> blogs = blogDao.getBlogList();
		for (Blog blog : blogs) {
			System.out.println(blog.getBlogId()+blog.getBlogContent()+blog.getBlogTitle());
			System.out.println(blog.getBlogId()+   blog.getBlogContent().length()+    blog.getBlogTitle().length());
		}
		((ConfigurableApplicationContext) context).close();
	}
	
	public void addblog(String blogTitle,String blogContent) {
		ApplicationContext context = new ClassPathXmlApplicationContext("app.xml");
		BlogDao blogDao = context.getBean("blogDao", BlogDao.class);
		blogDao.addBlog(blogTitle, blogContent);
		((ConfigurableApplicationContext) context).close();
	}
	

}
