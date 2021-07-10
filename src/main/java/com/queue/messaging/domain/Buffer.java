package com.queue.messaging.domain;

import com.queue.messaging.utilities.Queue;

/**
 * This class represents as wrapper class for the actual Queue class.
 * <p>
 * This has two states queue and the size which holds messages
 * <p>
 * Additionally, provides two method -
 * <p>
 * 1. add -> used for the producer producing the message in the buffer
 * <p>
 * 2. poll -> used for consumer consuming the message from buffer
 */
public class Buffer {
	
	private final Queue<String> queue;
	private final int size;
	
	public Buffer(int size) {
		this.size = size;
		this.queue = new Queue<>(size);
	}
	
	/**
	 * This method add the producer's message
	 *
	 * @param item represents the actual message
	 * @throws InterruptedException while the producer threads are waiting when buffer size is
	 *                              greater than equals to actual capacity provided initially.
	 */
	public void add(String item) throws InterruptedException {
		synchronized (this) {
			while (queue.getSize() >= size) {
				wait();
			}
			queue.enQueue(item);
			notify();
		}
	}
	
	/**
	 * This method is used for consuming the message by the consumer threads
	 *
	 * @return actual message
	 * @throws InterruptedException while the producer threads are waiting when buffer size is is
	 *                              empty to actual capacity provided initially.
	 */
	public String poll() throws InterruptedException {
		String value = "";
		synchronized (this) {
			while (queue.getSize() == 0) {
				wait();
			}
			try {
				value = queue.dequeue();
				
			} catch (Exception e) {
				System.out.println("Message: " + e.getLocalizedMessage());
				throw new InterruptedException();
			}
			notify();
			return value;
		}
	}
}
