package com.zgf.Test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandler implements InvocationHandler {
	private MsgSend msgSend;

	public ProxyHandler(MsgSend msgSend) {
		this.msgSend = msgSend;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("proxy start ----");
		method.invoke(msgSend, args);
		System.out.println("proxy end ----");
		return proxy;
	}

}
