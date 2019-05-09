package com.kgc.main.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.kgc.main.pojo.User;

@Mapper
public interface UserDao {
	@Select("select * from user where id = #{id}")
	User getUserById(int id);
	
	@Select("select * from user")
	List<User> getAllUser();
}
