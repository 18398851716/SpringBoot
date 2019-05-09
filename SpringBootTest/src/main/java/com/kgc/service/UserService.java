package com.kgc.service;

import java.util.List;

import com.kgc.entity.User;

public interface UserService {
	User getUserById(int id);
	List<User> getAllUser();
}
