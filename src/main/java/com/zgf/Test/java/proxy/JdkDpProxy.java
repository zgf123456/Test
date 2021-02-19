package com.zgf.Test.java.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk的动态代理，必须要有接口才行
 * 动态代理并不存在代理类, 代理对象直接由代理生成工具动态生成
 */
public class JdkDpProxy<T> implements InvocationHandler {

    //目标对象 - 泛型写法，比较通用，与具体类无关
    private T target;

    public JdkDpProxy(T target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("dpproxy before");
        return method.invoke(target, args);
    }

    public static void main(String[] args) {
        //创建目标对象
        IAccountService target = new AccountServiceImpl();
        //创建代理对象
        IAccountService accountService = (IAccountService) Proxy.newProxyInstance(JdkDpProxy.class.getClassLoader() //
                , target.getClass().getInterfaces() //
                , new JdkDpProxy(target));
        accountService.transfer();
    }
}
