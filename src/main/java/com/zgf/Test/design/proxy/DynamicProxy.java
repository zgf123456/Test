package com.zgf.Test.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by zgf on 17/6/15.
 */
public class DynamicProxy {
    public static void main(String[] args) {
        SendEmail sendEmail = new SendEmail();
        DynamicProxySend dynamicProxySend = new DynamicProxySend(sendEmail);
        Send send = (Send) Proxy.newProxyInstance(DynamicProxy.class.getClassLoader(), new Class[]{Send.class}, dynamicProxySend);
        send.sendMsg("aaa@123.com");
    }
}

class DynamicProxySend implements InvocationHandler {
    private Send send;

    public DynamicProxySend(Send send) {
        this.send = send;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("dynamicProxy before send");
        method.invoke(send, args);
        System.out.println("dynamicProxy after send");
        return null;
    }
}
