package org.springframework.amqp.helloworld;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.BindingBuilder.HeadersExchangeMapConfigurer.HeadersExchangeKeysBindingCreator;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfiguration2
{

    @Bean
    public ConnectionFactory connectionFactory()
    {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory( "localhost" );
        connectionFactory.setUsername( "guest" );
        connectionFactory.setPassword( "guest" );
        return connectionFactory;
    }

    @Bean
    public AmqpAdmin amqpAdmin()
    {
        return new RabbitAdmin( connectionFactory() );
    }

    @Bean
    // Every queue is bound to the default direct exchange
    public Queue helloWorldQueue()
    {
        return new Queue( SpringRabbitConstants.helloWorldQueueName2 );
    }

    @Bean
    public HeadersExchangeKeysBindingCreator binding()
    {
        return BindingBuilder.bind( helloWorldQueue() )
                             .to( new HeadersExchange( SpringRabbitConstants.helloWorldExchange ) ).whereAny( "headerKey" );
                             //.with( SpringRabbitConstants.helloWorldRoutingKey );
    }

}
