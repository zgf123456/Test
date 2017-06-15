package com.zgf.Test.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by zgf on 17/6/15.
 *
 * 动态代理的优势
 * 1. 是通用的代理类，无需实现接口
 * 2. 所有方法统一代理，如果需要区分，需要写额外的代码
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
    private Object proxyObj;

    public DynamicProxySend(Object proxyObj) {
        this.proxyObj = proxyObj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("dynamicProxy before send");
        System.out.println("aop log start");
        Object result = method.invoke(proxyObj, args);
        System.out.println("aop log end");
        System.out.println("dynamicProxy after send");
        return result;
    }
}
