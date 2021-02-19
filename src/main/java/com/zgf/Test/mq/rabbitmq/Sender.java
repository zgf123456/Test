package com.zgf.Test.mq.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.nio.charset.StandardCharsets;

public class Sender {
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) throws Exception {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("10.143.150.182");
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        // 队列定义
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        String message = "Hello World";
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes(StandardCharsets.UTF_8));
        System.out.println(" [x] Send '" + message + "'");
    }
}
