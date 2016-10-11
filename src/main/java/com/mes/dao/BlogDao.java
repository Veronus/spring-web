package com.mes.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.mes.meta.Blog;


@Repository
public interface BlogDao {
	
	@Results({
		@Result(property = "blogId", column = "blogId"),
		@Result(property = "blogTitle", column = "blogTitle"),
		@Result(property = "blogContent", column = "blogContent")
	})
	@Update("INSERT INTO blog(blogTitle,blogContent) values(#{blogTitle},#{blogContent})")
	public void addBlog(@Param("blogTitle")String blogTitle, @Param("blogContent")String blogContent);
	
	@Results({
		@Result(property = "blogId", column = "blogId"),
		@Result(property = "blogTitle", column = "blogTitle"),
		@Result(property = "blogContent", column = "blogContent")
	})
	@Select("select * from blog")
	public List<Blog> getBlogList();
}
