package com.zgf.Test.mq.rocketmq.productor;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * 过滤消息生产者，设置自定义属性
 * <p>
 * 底层通过  this.properties = new HashMap();  一个HashMap对象实现，与keys的相同，不同的是keys使用的内置的key(KEYS)
 */
public class FilterProductor {
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

            // 设置自定义属性
//            msg.setKeys(); //使用内置的KEYS
            msg.putUserProperty("a", String.valueOf(i));

            //Call send message to deliver message to one of brokers.
            // 同步发送，关注返回值，默认超时时间 3000ms
            SendResult sendResult = producer.send(msg);
            System.out.printf("%s%n", sendResult);
        }
        //Shut down once the producer instance is not longer in use.
        producer.shutdown();
    }
}
