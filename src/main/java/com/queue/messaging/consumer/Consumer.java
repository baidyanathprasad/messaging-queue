package com.queue.messaging.consumer;

import com.queue.messaging.domain.Buffer;

/**
 * Consumer class represents the consumer which has single method consume.
 */
public class Consumer {
	
	/**
	 * This method takes buffer and consumes data from the buffer
	 *
	 * @param buffer represents initial buffer defined that holds no of message that are available
	 *               for the consumes.
	 * @return new consumer @Thread which is responsible for consuming the data in the called class
	 */
	public Thread consume(Buffer buffer) {
		
		return new Thread(() -> {
			try {
				while (true) {
					String value = buffer.poll();
					System.out.println("Consume " + value);
					Thread.sleep(1000);
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
	}
}
