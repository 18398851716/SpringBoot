package com.kgc.main.service;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.kgc.main.dao.UserDao;
import com.kgc.main.pojo.User;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao ud;
	
	//private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
    private RedisTemplate redisTemplate;
	
	@Autowired
    private SolrClient client;
	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		SolrDocument document;
		try {
			document = client.getById("mycore", "101");
			System.out.println(document);
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 从缓存中获取员工信息
        String key = "user_" + id;
		ValueOperations<String, User> operations = redisTemplate.opsForValue();
        // 缓存存在
		boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            User user = operations.get(key);
            System.out.println("从缓存中获取了用户 >> " + user.toString());
            return user;
        }else {       	
        	// 从 DB 中获取城市信息
        	User user = ud.getUserById(id);
        	// 插入缓存
        	//operations.set(key, user,30,TimeUnit.MINUTES);
        	operations.set(key, user,15,TimeUnit.MINUTES);
        	System.out.println("用户插入缓存 >> " + user.toString());
        	return user;
        }
	}
	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return ud.getAllUser();
	}
	@Override
	public void deleteCache() {
		// TODO Auto-generated method stub
		redisTemplate.delete("user_101");
	}

}
