package com.zgf.Test.design.proxy;

/**
 * Created by zgf on 17/6/15.
 *
 *
 * 静态代理的缺点是
 * 1. 必须实现与被代理对象相同接口
 * 2. 且持有相同接口的实例化对象
 * 3. 如果被代理接口有较多的方法，写起来费劲
 * 4. 不同接口对象需要些不同的代理类
 */
public class StaticProxy {
    public static void main(String[] args) {
        SendEmail sendEmail = new SendEmail();
        StaticProxySend staticProxySend = new StaticProxySend(sendEmail);
        staticProxySend.sendMsg("aaa@aaa.123");

    }
}

class StaticProxySend implements Send {
    private Send send;

    public StaticProxySend(Send send) {
        this.send = send;
    }

    @Override
    public void sendMsg(String addr) {
        System.out.println("before send");
        send.sendMsg(addr);
        System.out.println("after send");
    }
}