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
	
	@Results({ @Result(property = "userid", column = "userid"), 
		   @Result(property = "username", column = "username") })
	@Select("insert into user values(#{userid},#{username})")
	public void insertUser(@Param("userid")int userid,@Param("username")String username);
	
	@Results({ @Result(property = "userid", column = "userid"), 
		   @Result(property = "username", column = "username") })
	@Update("update user set username = #{username} where userid = #{userid}")
	public void updateUser(@Param("userid")int userid,@Param("username")String username);
	
	@Results({ @Result(property = "userid", column = "userid"), 
		   @Result(property = "username", column = "username") })
	@Delete("Delete from user where userid = #{userid}")
	public void DeleteUser(@Param("userid")int userid);
	
	@Results({ @Result(property = "userid", column = "userid"), 
			   @Result(property = "username", column = "username") })
	@Select("select * from user")
	public List<User> getUserList();
}
