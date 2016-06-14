package com.zgf.Test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class TestDynamicProxy {
	public static void main(String[] args) {
		MsgSend msgSend = new EmailMsgSend();
		InvocationHandler handler = new ProxyHandler(msgSend);
		MsgSend aaa = (MsgSend) Proxy.newProxyInstance(MsgSend.class.getClassLoader(), new Class[] { MsgSend.class },
				handler);
		aaa.send("aaa");
	}
}
