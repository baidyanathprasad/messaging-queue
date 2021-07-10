package com.queue.messaging.producer;

import com.queue.messaging.domain.Buffer;

/**
 * This class represents the Producer class which has one method produce and responsible for the
 * producing the message to the buffer.
 */
public class Producer {
	
	/**
	 * This method is used for the adding the message to
	 *
	 * @param buffer represents the initial buffer
	 * @param json   message
	 * @return producer @Thread
	 */
	public Thread produce(Buffer buffer, String json) {
		
		return new Thread(() -> {
			try {
				int counter = 0;
				while (true) {
					buffer.add(json + " - " + counter);
					System.out.println("Produced " + " - " + counter);
					counter++;
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
	}
}
