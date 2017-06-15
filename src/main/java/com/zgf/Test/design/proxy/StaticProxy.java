package com.zgf.Test.design.proxy;

/**
 * Created by zgf on 17/6/15.
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