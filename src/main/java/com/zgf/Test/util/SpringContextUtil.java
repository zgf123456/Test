package com.zgf.Test.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 获取spring上下文工具
 * 
 * @author guofengzheng1
 *
 * @version 2015-5-26 上午11:05:58
 */
public class SpringContextUtil implements ApplicationContextAware {
	private static ApplicationContext context;// 声明一个静态变量保存

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		SpringContextUtil.context = context;
	}

	public static ApplicationContext getContext() {
		return SpringContextUtil.context;
	}
}
