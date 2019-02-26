package org.springframework.amqp.helloworld;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfiguration
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
    public Queue helloWorldQueue()
    {
        return new Queue( SpringRabbitConstants.helloWorldQueueName );
    }

    // if the default exchange isn't configured to your liking....P2PBinding
    @Bean
    public Binding binding()
    {
        /*return BindingBuilder.bind( helloWorldQueue() )
                             .to( new HeadersExchange( SpringRabbitConstants.helloWorldExchange ) ).where( "headerKey" );*/
        
        Map<String, Object> keyValues = new HashMap<>();
        keyValues.put ("headerKey1", "headerValue1" );
        keyValues.put( "headerKey2", "headerValue5" );
        Binding binding = null;
        BindingBuilder.HeadersExchangeMapConfigurer mapConfig = BindingBuilder.bind( helloWorldQueue() )
                                                                              .to( new HeadersExchange( SpringRabbitConstants.helloWorldExchange ) );
        
        binding = mapConfig.whereAll(keyValues ).match();

        return binding;
    }

}
