package org.springframework.amqp.helloworld;

interface SpringRabbitConstants
{
    String helloWorldQueueName = "hello.world.queue";
    String helloWorldQueueName2 = "hello.world.queue2";
    
    //All producer will produce to the same exchange
    String helloWorldExchange = "hello.world.exchange";
    
    //Producer1 will produce to this exchange bound with the routing key helloWorldRoutingKey
    String helloWorldRoutingKey = "hello.worldfirst.routingkeyfirst";
    //Producer2 will produce to this exchange bound with the routing key helloWorldRoutingKey2
    String helloWorldRoutingKey2 = "hello.worldsecond.routingkeysecond";
    
    //Consumer1 queue will bind to the exchange helloWorldExchange and 
    //topicRoutingKey1 and consume message of routing key expression match produced 
    //by producer matching the below type.
    String topicRoutingKey1 = "hello.worldfirst.*";
    //Consumer2 queue will bind to the same exchange helloWorldExchange with routing key as below expression
    String topicRoutingKey2 = "hello.worldsecond.*";
}
