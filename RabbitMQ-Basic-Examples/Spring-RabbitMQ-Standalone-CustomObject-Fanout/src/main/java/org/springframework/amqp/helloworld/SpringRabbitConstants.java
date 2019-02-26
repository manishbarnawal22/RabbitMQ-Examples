package org.springframework.amqp.helloworld;

interface SpringRabbitConstants
{
    String helloWorldQueueName = "hello.world.queue";
    String helloWorldQueueName2 = "hello.world.queue2";
    
    //All producer will produce to the same exchange
    String helloWorldExchange = "hello.world.exchange";
    
    //Producer1 will produce to the exchange bound with the routing key helloWorldRoutingKey
    String helloWorldRoutingKey = "hello.worldfirst.routingkeyfirst";
    //Producer2 will produce to this exchange bound with the routing key helloWorldRoutingKey2
    String helloWorldRoutingKey2 = "hello.worldsecond.routingkeysecond";
    
    //Bind the helloWorldQueueName & helloWorldQueueName2 queue with same exchange with any random routing key
    String fanoutRandomRoutingKey1 = "fanout.random.routingkey1";
    String fanoutRandomRoutingKey2 = "fanout.random.routingkey2";
}
