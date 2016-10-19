package com.mes.test;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mes.meta.User;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

public class Test {

	public static void main(String[] args) throws IOException, TemplateException {
		
		/*Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
		cfg.setDirectoryForTemplateLoading(
				new File("E:\\NeonWorkspace\\spring-web\\src\\main\\webapp\\WEB-INF\\freemarker"));
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		Template ftl = cfg.getTemplate("users.ftl");
		
		TestUser testUser = new TestUser();
		Map<String, Object> root = new HashMap<String, Object>();
		System.out.println("this is test users:"+testUser.getUsers());
		
		for (User user : testUser.getUsers()) {
			System.out.println(user.getUserid()+ user.getUsername());
			root.put("id", user.getUserid());
			root.put("name", user.getUsername());
		}
		
		System.out.println(testUser.getUsers().get(4).getUserid());*/
		
	}

}
