package com.zgf.Test.mq.rocketmq.comsumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.MessageSelector;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * 过滤消息
 * 费者将接收包含TAGA或TAGB或TAGC的消息。但是限制是一个消息只能有一个标签，这对于复杂的场景可能不起作用。
 * 这时可以通过自定义属性实现过滤
 */
public class FilterConsumer {
    public static void main(String[] args) throws Exception {
        // Instantiate with specified consumer group name.
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("zgf");

        // Specify name server addresses.
        consumer.setNamesrvAddr("10.143.150.183:9876");

        // Subscribe one more more topics to consume.
//        consumer.subscribe("ZgfTopicTest", "*");
        consumer.subscribe("ZgfTopicTest", MessageSelector.bySql("a between 0 and 3"));
//        consumer.subscribe("ZgfTopicTest", MessageSelector.byTag("*"));



        // Register callback to execute on arrival of messages fetched from brokers.
        consumer.registerMessageListener(new MessageListenerConcurrently() {

            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
                                                            ConsumeConcurrentlyContext context) {
                System.out.printf("%s Receive New Messages: %s %n", Thread.currentThread().getName(), msgs);

                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        //Launch the consumer instance.
        consumer.start();

        System.out.printf("Consumer Started.%n");
    }
}
