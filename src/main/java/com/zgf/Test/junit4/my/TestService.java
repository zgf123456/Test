package com.zgf.Test.junit4.my;

import org.springframework.stereotype.Service;

import com.zgf.Test.junit4.my.model.User;

@Service
public class TestService {
	public User getUser() {
		User user = new User();
		user.setAge(20);
		user.setName("zgf");
		return user;
	}
}
