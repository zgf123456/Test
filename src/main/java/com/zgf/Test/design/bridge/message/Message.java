package com.zgf.Test.design.bridge.message;

/**
 * 消息接口
 * @author zgf
 *
 */
public interface Message {
	void send(String message, String toUser);
}
