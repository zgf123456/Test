package com.zgf.Test.mq.rocketmq.productor;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * 批量发送
 * 复杂度只有当你发送大批量时才会增长，你可能不确定它是否超过了大小限制（4MB）。这时候你最好把你的消息列表分割一下：
 */
public class BatchProductor {
    public static void main(String[] args) throws Exception {
        //Instantiate with a producer group name.
        DefaultMQProducer producer = new
                DefaultMQProducer("zgf");
        // Specify name server addresses.
        producer.setNamesrvAddr("10.143.150.183:9876");
        //Launch the instance.
        producer.start();

        List<Message> messages = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            //Create a message instance, specifying topic, tag and message body.
            Message msg = new Message("ZgfTopicTest" /* Topic */,
                    "TagA" /* Tag */,
                    ("Hello RocketMQ " +
                            i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
            );
            messages.add(msg);
        }

        // 批量发送
        SendResult sendResult = producer.send(messages);
        System.out.printf("%s%n", sendResult);

        //Shut down once the producer instance is not longer in use.
        producer.shutdown();
    }
}
