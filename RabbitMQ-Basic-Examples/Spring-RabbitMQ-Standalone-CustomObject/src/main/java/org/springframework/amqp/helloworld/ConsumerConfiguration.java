package org.springframework.amqp.helloworld;

import org.springframework.amqp.helloworld.HelloWorldConfiguration;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsumerConfiguration extends HelloWorldConfiguration
{

    @Bean
    public SimpleMessageListenerContainer listenerContainer()
    {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory( connectionFactory() );
        container.setQueueNames( SpringRabbitConstants.helloWorldQueueName );
        MessageListenerAdapter lMessageListenerAdapter = new MessageListenerAdapter( new HelloWorldHandler() );
        lMessageListenerAdapter.setDefaultListenerMethod( "handle" );
        container.setMessageListener( lMessageListenerAdapter );
        return container;
    }

}
