package org.springframework.amqp.helloworld;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducerConfiguration
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
    public Exchange exchange()
    {
        return ExchangeBuilder.topicExchange( SpringRabbitConstants.helloWorldExchange ).build();
    }

    @Bean
    public AmqpAdmin amqpAdmin()
    {
        return new RabbitAdmin( connectionFactory() );
    }

    @Bean
    public RabbitTemplate rabbitTemplate()
    {
        RabbitTemplate template = new RabbitTemplate( connectionFactory() );
        //The routing key is set to the name of the queue by the broker for the default exchange.
        //template.setRoutingKey( SpringRabbitConstants.helloWorldRoutingKey );
        template.setExchange( SpringRabbitConstants.helloWorldExchange );
        return template;
    }
}
