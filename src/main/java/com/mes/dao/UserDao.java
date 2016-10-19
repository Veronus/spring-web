package com.mes.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.mes.meta.User;

@Repository
public interface UserDao {
	
	@Update("create table user (userid int, username varchar(50))")
	public void creatTable();
	
	@Results({ @Result(property = "userName", column = "userName"), 
		   @Result(property = "userPassword", column = "userPassword") })
	@Select("insert into user(userName,userPassword) values(#{userName},#{userPassword})")
	public void insertUser(@Param("userName")String userName,@Param("userPassword")String userPassword);
	
	@Results({ @Result(property = "userName", column = "userName"), 
		   @Result(property = "userPassword", column = "userPassword") })
	@Delete("Delete from user where userid = #{userid}")
	public void DeleteUser(@Param("userid")int userid);
	
	@Results({ @Result(property = "userName", column = "userName"), 
		   @Result(property = "userPassword", column = "userPassword") })
	@Select("select * from user")
	public List<User> getUserList();
}
