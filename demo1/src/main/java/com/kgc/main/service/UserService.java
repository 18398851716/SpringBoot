package com.kgc.main.service;

import java.util.List;

import com.kgc.main.pojo.User;

public interface UserService {
	User getUserById(int id);
	List<User> getAllUser();
	void deleteCache();
}
