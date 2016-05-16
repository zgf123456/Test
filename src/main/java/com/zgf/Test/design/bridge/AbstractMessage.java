package com.zgf.Test.design.bridge;

import com.zgf.Test.design.bridge.message.Message;

/**
 * 抽象消息实体
 * 
 * @author zgf
 *
 */
public class AbstractMessage {
	protected Message message;

	public AbstractMessage(Message message) {
		super();
		this.message = message;
	}

	public void sendMessage(String message, String toUser) {
		this.message.send(message, toUser);
	}
}
