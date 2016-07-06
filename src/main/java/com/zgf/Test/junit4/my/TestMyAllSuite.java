package com.zgf.Test.junit4.my;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@RunWith(Suite.class)
@Suite.SuiteClasses({ TestA.class, TestB.class })
public class TestMyAllSuite {
	@SuppressWarnings("resource")
	@BeforeClass
	public static void init() {
		System.out.println("TestMyAllSuite -> before class");
		new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	}
}
