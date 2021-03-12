package com.zgf.Test.mq.rocketmq.productor;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * 单向消息
 * 是将消息直接放入本地socket缓冲区，不管发送结果成功还是失败，速度非常快，适用于不敏感场景，比如日志
 */
public class OnewayProductor {
    public static void main(String[] args) throws Exception {
        //Instantiate with a producer group name.
        DefaultMQProducer producer = new
                DefaultMQProducer("zgf");
        // Specify name server addresses.
        producer.setNamesrvAddr("10.143.150.183:9876");
        //Launch the instance.
        producer.start();
        for (int i = 0; i < 10; i++) {
            //Create a message instance, specifying topic, tag and message body.
            Message msg = new Message("ZgfTopicTest" /* Topic */,
                    "TagA" /* Tag */,
                    ("Hello RocketMQ " +
                            i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
            );
            //Call send message to deliver message to one of brokers.
            // 发送单向消息，没有任何返回结果
            producer.sendOneway(msg);
        }
        //Shut down once the producer instance is not longer in use.
        producer.shutdown();
    }
}
