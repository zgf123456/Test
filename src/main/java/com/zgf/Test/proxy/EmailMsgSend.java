package com.zgf.Test.proxy;

public class EmailMsgSend implements MsgSend {

	@Override
	public void send(String str) {
		System.out.println("邮件发送" + str);
	}

}
