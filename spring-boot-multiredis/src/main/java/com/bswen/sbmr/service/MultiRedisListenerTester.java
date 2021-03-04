package com.bswen.sbmr.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Component;

/**
 * test redis pub/sub from multiple redis servers.
 */
@Component
public class MultiRedisListenerTester {
    @Bean
    RedisMessageListenerContainer container1(@Qualifier("redis1ConnectionFactory") RedisConnectionFactory connectionFactory,

                                            MessageListenerAdapter listenerAdapter) {

        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(listenerAdapter, new PatternTopic("tasks1"));

        return container;
    }

    @Bean
    RedisMessageListenerContainer container2(@Qualifier("redis2ConnectionFactory") RedisConnectionFactory connectionFactory,

                                             MessageListenerAdapter listenerAdapter) {

        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(listenerAdapter, new PatternTopic("tasks2"));

        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(MyMessageReceiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }
}
