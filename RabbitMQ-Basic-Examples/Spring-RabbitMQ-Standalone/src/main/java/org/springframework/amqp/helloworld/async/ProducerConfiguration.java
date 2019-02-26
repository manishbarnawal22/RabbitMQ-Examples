package org.springframework.amqp.helloworld.async;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.ScheduledAnnotationBeanPostProcessor;

@Configuration
public class ProducerConfiguration {

	protected static final String helloWorldRoutingKey = "hello.world.routingkey";
	protected static final String helloWorldExchangeName = "hello.world.exchange";

	@Bean
	public RabbitTemplate rabbitTemplate() {
		RabbitTemplate template = new RabbitTemplate(connectionFactory());
		template.setRoutingKey(helloWorldRoutingKey);
		template.setExchange( helloWorldExchangeName );
		return template;
	}
	
	@Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }
	
	@Bean
	public Exchange exchange()
	{
	    return ExchangeBuilder.directExchange( helloWorldExchangeName ).build();
	}

	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost");
		connectionFactory.setUsername("guest");
		connectionFactory.setPassword("guest");
		return connectionFactory;
	}

	@Bean
	public ScheduledProducer scheduledProducer() {
		return new ScheduledProducer();
	}

	@Bean
	public BeanPostProcessor postProcessor() {
		return new ScheduledAnnotationBeanPostProcessor();
	}

	static class ScheduledProducer {

		@Autowired
		private volatile RabbitTemplate rabbitTemplate;

		private final AtomicInteger counter = new AtomicInteger();

		@Scheduled(fixedRate = 3000)
		public void sendMessage() {
			//rabbitTemplate.convertAndSend( helloWorldExchangeName, helloWorldRoutingKey, "Hello World " + counter.incrementAndGet());
		    rabbitTemplate.convertAndSend( "Hello World " + counter.incrementAndGet() );
			System.out.println("Produced: " + "Hello World " + counter.incrementAndGet());
		}
	}

}
