package com.zgf.Test.design.bridge.message;

public class MessageSms implements Message {

	@Override
	public void send(String message, String toUser) {
		System.out.println("短信发送消息【" + message + "】to【" + toUser + "】");
	}

}
