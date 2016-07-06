package com.zgf.Test.junit4.my;

import org.junit.Test;

import com.zgf.Test.junit4.my.model.User;
import com.zgf.Test.util.SpringContextUtil;

public class TestA {
	@Test
	public void a() {
		System.out.println("TestA -> a");
		TestService testService = SpringContextUtil.getContext().getBean(TestService.class);
		User user = testService.getUser();
		System.out.println(user);
	}
}
