package org.springframework.amqp.helloworld.async;

public class HelloWorldHandler {

	public void handle(String text) {
		System.out.println("Received: " + text);
	}

}
