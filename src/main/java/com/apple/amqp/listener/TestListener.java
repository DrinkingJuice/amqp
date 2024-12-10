package com.apple.amqp.listener;

import com.apple.amqp.entity.User;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TestListener {

    @RabbitListener(queues = "yyds", messageConverter = "jacksonConverter")   //定义此方法为队列yyds的监听器，一旦监听到新的消息，就会接受并处理
    public void test(Message message){
        System.out.println(new String(message.getBody()));
    }

    @RabbitListener(queues = "dl-yyds", messageConverter = "jacksonConverter")   //定义死信队列的监听方式
    public void receiver(User user){
        System.out.println(user);
    }
}
