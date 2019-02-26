package org.springframework.amqp.helloworld.async;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Consumer {

	@SuppressWarnings( "resource" )
    public static void main(String[] args) {
		new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
	}

}
