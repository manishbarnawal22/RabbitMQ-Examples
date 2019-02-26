package org.springframework.amqp.helloworld;

public class HelloWorldHandler
{

    public void handle( Employee emp )
    {
        System.out.println( "Received: " + emp.getName() );
        System.out.println( "Received: " + emp.getAddress().getPin() );
    }

}
