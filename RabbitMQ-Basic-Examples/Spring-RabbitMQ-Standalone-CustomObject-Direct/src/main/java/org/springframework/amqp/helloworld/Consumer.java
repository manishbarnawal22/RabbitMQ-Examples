package org.springframework.amqp.helloworld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Consumer
{

    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext( ConsumerConfiguration.class );
    }
}
