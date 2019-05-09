package com.kgc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

import com.kgc.entity.User;

@MapperScan
public interface UserDao {
	@Select("select * from user where id = #{id}")
	User getUserById(int id);
	
	@Select("select * from user")
	List<User> getAllUser();
}
