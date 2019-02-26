package org.springframework.amqp.helloworld;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Producer
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext( ProducerConfiguration.class );
        AmqpTemplate amqpTemplate = context.getBean( AmqpTemplate.class );

        Employee lEmp = new Employee();
        lEmp.setId( 134 );
        lEmp.setName( "Portal.Admin" );
        Address address = new Address();
        address.setPin( 123 );
        lEmp.setAddress( address );

        amqpTemplate.convertAndSend( SpringRabbitConstants.helloWorldExchange, SpringRabbitConstants.helloWorldRoutingKey, lEmp );
        System.out.println( "Sent: Emp Name:" + lEmp.getName() );
    }

}
