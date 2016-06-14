package com.zgf.Test.proxy;

public class TestStaticProxy {
	public static void main(String[] args) {
		EmailMsgSend emailMsgSend = new EmailMsgSend();
		MsgSend msgSend = new StaticEmailMsgSendProxy(emailMsgSend);
		
		emailMsgSend.send("test");
		msgSend.send("test1");
	}
}

class StaticEmailMsgSendProxy implements MsgSend {
	private EmailMsgSend EmailMsgSend;

	public StaticEmailMsgSendProxy(com.zgf.Test.proxy.EmailMsgSend emailMsgSend) {
		super();
		EmailMsgSend = emailMsgSend;
	}

	@Override
	public void send(String str) {
		System.out.println("代理发送前");
		EmailMsgSend.send(str);
		System.out.println("代理发送后");
	}

}