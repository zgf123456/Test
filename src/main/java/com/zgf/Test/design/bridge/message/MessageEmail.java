package com.zgf.Test.design.bridge.message;

public class MessageEmail implements Message {

	@Override
	public void send(String message, String toUser) {
		System.out.println("邮件发送消息【" + message + "】to【" + toUser + "】");
	}

}
