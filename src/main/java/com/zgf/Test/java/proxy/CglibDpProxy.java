package com.zgf.Test.java.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * JDK动态代理必须要有接口, 但如果要代理一个没有接口的类该怎么办呢?
 * 这时我们可以使用CGLIB动态代理. CGLIB动态代理的原理是生成目标类的子类, 这个子类对象就是代理对象, 代理对象是被增强过的.
 * 注意: 不管有没有接口都可以使用CGLIB动态代理, 而不是只有在无接口的情况下才能使用.
 */
public class CglibDpProxy implements MethodInterceptor {

    /**
     * 被代理的对象
     */
    private Object object;

    /**
     * 构造方法注入被代理对象
     *
     * @param object 被代理的对象
     */
    public CglibDpProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("CglibDpProxy before");
        return method.invoke(object, objects);
    }

    public static void main(String[] args) {
        //创建代理对象
        AccountServiceImpl accountService = new AccountServiceImpl();
        AccountServiceImpl proxy = (AccountServiceImpl) Enhancer.create(AccountServiceImpl.class, new CglibDpProxy(accountService));
        proxy.transfer();
    }
}
