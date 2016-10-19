package com.mes.test;

import java.io.File;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mes.dao.UserDao;
import com.mes.meta.User;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

public class TestFreeMarker {

	public static void main(String[] args) throws Exception {
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
		cfg.setDirectoryForTemplateLoading(
				new File("D:\\TouchWorkspace\\webFrame\\src\\main\\webapp\\freemarker"));
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

		Template ftl = cfg.getTemplate("user.ftl");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("app.xml");
		UserDao userDao = context.getBean("userDao", UserDao.class);
		List<User> users = userDao.getUserList();
		Map<String, Object> root = new HashMap<String, Object>();
		
		for (User user : users) {

			root.put("username", user.getUserName());
		}
		
		System.out.println(root);

		Writer out = new OutputStreamWriter(System.out);
		ftl.process(users, out);
		
		
		((ConfigurableApplicationContext) context).close();
	}

}
