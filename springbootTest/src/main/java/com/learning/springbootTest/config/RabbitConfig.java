package com.learning.springbootTest.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;



@Component
public class RabbitConfig {

    @Bean
    public Queue queueA(){
        return new Queue("QueueA");
    }

    @Bean
    public Queue queueB(){
        return new Queue("QueueB");
    }

    /**
     * 建立 fanout 模式的交换机
     * @return
     */
    @Bean
    FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange");
    }

    /**
     * 绑定队列A到交换机
     * @param queueA
     * @param fanoutExchange
     * @return
     */
    @Bean
    public Binding bindingQueueA(Queue queueA, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queueA).to(fanoutExchange);
    }

    /**
     * 绑定队列B到交换机
     * @param queueB
     * @param fanoutExchange
     * @return
     */
    @Bean
    public Binding bindingQueueB(Queue queueB, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queueB).to(fanoutExchange);
    }
}
