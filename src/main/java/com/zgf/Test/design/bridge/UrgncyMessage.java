package com.zgf.Test.design.bridge;

import com.zgf.Test.design.bridge.message.Message;

/**
 * 加急消息实体
 * 
 * @author zgf
 *
 */
public class UrgncyMessage extends AbstractMessage {

	public UrgncyMessage(Message message) {
		super(message);
	}

	@Override
	public void sendMessage(String message, String toUser) {
		message = "加急:" + message;
		super.sendMessage(message, toUser);
	}
}
