package com.kgc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kgc.dao.UserDao;
import com.kgc.entity.User;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao ud;
	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return ud.getUserById(id);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return ud.getAllUser();
	}

}
