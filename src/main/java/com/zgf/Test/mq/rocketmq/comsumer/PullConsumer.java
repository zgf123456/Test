package com.zgf.Test.mq.rocketmq.comsumer;

import org.apache.rocketmq.client.consumer.*;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;

import java.util.List;

public class PullConsumer {
    public static void main(String[] args) throws Exception {

        MQPullConsumerScheduleService scheduleService = new MQPullConsumerScheduleService("zgf");
        scheduleService.getDefaultMQPullConsumer().setNamesrvAddr("10.143.150.183:9876");


        scheduleService.registerPullTaskCallback("ZgfTopicTest", new PullTaskCallback() {
            @Override
            public void doPullTask(MessageQueue messageQueue, PullTaskContext pullTaskContext) {
                try {
                    MQPullConsumer pullConsumer = pullTaskContext.getPullConsumer();
                    long offset = pullConsumer.fetchConsumeOffset(messageQueue, false);
                    PullResult pullResult = pullConsumer.pull(messageQueue, "*", offset, 1);

                    switch (pullResult.getPullStatus()) {
                        case FOUND:
                            //打印消息
                            List<MessageExt> messageExtList = pullResult.getMsgFoundList();
                            for (MessageExt msg : messageExtList) {
                                System.out.printf("%s Receive New Messages: %s %n", Thread.currentThread().getName(), msg);
                            }
                            pullConsumer.updateConsumeOffset(messageQueue, pullResult.getNextBeginOffset());
                            break;
                        case NO_MATCHED_MSG:
                            break;
                        case NO_NEW_MSG:
                        case OFFSET_ILLEGAL:
                            break;
                        default:
                            break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        scheduleService.start();
    }
}
