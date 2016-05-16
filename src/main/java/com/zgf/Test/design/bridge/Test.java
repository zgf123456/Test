package com.zgf.Test.design.bridge;

import com.zgf.Test.design.bridge.message.Message;
import com.zgf.Test.design.bridge.message.MessageEmail;
import com.zgf.Test.design.bridge.message.MessageSms;

public class Test {
	public static void main(String[] args) {
		Message msgSms = new MessageSms();
		Message msgEmail = new MessageEmail();
		
		
		AbstractMessage message1 = new CommonMessage(msgEmail);
		AbstractMessage message2 = new UrgncyMessage(msgSms);
		message1.sendMessage("aaaaa", "zgf");
		message2.sendMessage("bbbbb", "zgf");
	}
}
