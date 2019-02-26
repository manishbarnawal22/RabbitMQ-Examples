package org.springframework.amqp.helloworld;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Producer2
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext( ProducerConfiguration2.class );
        AmqpTemplate amqpTemplate = context.getBean( AmqpTemplate.class );

        Employee lEmp = new Employee();
        lEmp.setId( 134 );
        lEmp.setName( "Manish.Barnawal" );
        Address address = new Address();
        address.setPin( 456 );
        lEmp.setAddress( address );

        amqpTemplate.convertAndSend( SpringRabbitConstants.helloWorldExchange, SpringRabbitConstants.helloWorldRoutingKey2, lEmp );
        System.out.println( "Producer2 Sent: Emp Name:" + lEmp.getName() );
    }

}
