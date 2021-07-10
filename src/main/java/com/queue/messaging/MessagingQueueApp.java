package com.queue.messaging;

import com.queue.messaging.consumer.Consumer;
import com.queue.messaging.domain.Buffer;
import com.queue.messaging.producer.Producer;

/**
 * MessagingQueueApp is main class where buffer size and no of consumer and publishers thread
 */
public class MessagingQueueApp {
	
	public static void main(String[] args) throws InterruptedException {
		
		// Create Buffer size of queue
		Buffer buffer = new Buffer(2);
		
		String jsonString = "{\"id\":\"1\",\"name\":\"jon doe\",\"age\":\"22\"}";
		Thread producerThread = new Producer().produce(buffer, jsonString);
		Thread consumerThread1 = new Consumer().consume(buffer);
		Thread consumerThread2 = new Consumer().consume(buffer);
		
		producerThread.start();
		consumerThread1.start();
		consumerThread2.start();
		
		producerThread.join();
		consumerThread1.join();
		consumerThread2.join();
	}
}
