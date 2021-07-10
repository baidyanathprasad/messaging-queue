package com.queue.messaging.utilities;

/**
 * A class that represents the Queue Data structures with basic functionalities.
 */
public class Queue<T> {
	
	private int front;
	private int back;
	private int size;
	private int capacity;
	private T[] arr;
	
	public Queue(int capacity) {
		this.capacity = capacity;
		front = this.size = 0;
		this.back = capacity - 1;
		arr = (T[]) new Object[this.capacity];
	}
	
	/**
	 * This method checks if the queue is full or not.
	 *
	 * @param queue represents the actual queue
	 * @return true if the queue is full else false
	 */
	public boolean isFull(Queue<T> queue) {
		return (queue.size == queue.capacity);
	}
	
	/**
	 * This method checks if the queue is empty or not.
	 *
	 * @param queue queue represents the actual queue
	 * @return true if the queue is empty else false
	 */
	public boolean isEmpty(Queue<T> queue) {
		return (queue.size == 0);
	}
	
	/**
	 * This method add the items into the queue.
	 *
	 * @param items represents generic type T of the item.
	 */
	public void enQueue(T items) {
		if (isFull(this)) {
			return;
		}
		
		this.back = (this.back + 1)
			            % this.capacity;
		this.arr[this.front] = items;
		this.size = this.size + 1;
	}
	
	/**
	 * This method removing the items from queue
	 *
	 * @return front elements and removes the same item from queue.
	 * @throws Exception when size if full throws exception saying size if full
	 */
	public T dequeue() throws Exception {
		if (isEmpty(this)) {
			throw new Exception("Queue size is full");
		}
		
		T item = this.arr[this.front];
		this.front = (this.front + 1)
			             % this.capacity;
		this.size = this.size - 1;
		return item;
	}
	
	/**
	 * This method gives the front element item from the queue.
	 *
	 * @return item from front in the queue without removing it from queue
	 * @throws Exception when the queue is empty
	 */
	public T getFront() throws Exception {
		if (isEmpty(this)) {
			throw new Exception("Queue is empty");
		}
		
		return this.arr[this.front];
	}
	
	/**
	 * This method gives the back element item from the queue.
	 *
	 * @return item from back in the queue without removing it from queue
	 * @throws Exception Exception when the queue is empty
	 */
	public T getBack() throws Exception {
		if (isEmpty(this)) {
			throw new Exception("Queue is empty");
		}
		
		return this.arr[this.back];
	}
	
	/**
	 * This method calculates the current size of the queue
	 *
	 * @return current queue size
	 */
	public int getSize() {
		return this.size;
	}
	
}
