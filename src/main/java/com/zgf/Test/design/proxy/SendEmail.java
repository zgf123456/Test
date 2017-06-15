package com.zgf.Test.design.proxy;

/**
 * Created by zgf on 17/6/15.
 */
public class SendEmail implements Send {
    @Override
    public void sendMsg(String addr) {
        System.out.println("send email to " + addr);
    }
}
