package com.DSProblems.LinkedList;

import java.util.Arrays;

public class QueueMain {

	public static void main(String[] args) {
		QueueArray queueA = new QueueArray(5);
		queueA.enQueue(5);
		queueA.enQueue(4);
		queueA.enQueue(3);
		queueA.deQueue();
		queueA.enQueue(2);
		queueA.enQueue(1);

		System.out.println("Queue Array is:" + Arrays.toString(queueA.arr));
		
		CircularQueueArray cQueueA = new CircularQueueArray(4);
		cQueueA.enQueue(10);
		cQueueA.enQueue(20);
		cQueueA.enQueue(30);
		cQueueA.enQueue(40);
		
		System.out.println("Queue Array is:" + Arrays.toString(cQueueA.arr));
		cQueueA.deQueue();
		cQueueA.enQueue(50);
		cQueueA.deQueue();
		cQueueA.enQueue(60);
		cQueueA.deQueue();
		cQueueA.deQueue();
		cQueueA.deQueue();
		System.out.println("Queue Array is:" + Arrays.toString(cQueueA.arr));
		
		Queue queue = new Queue();
		queue.enQueue(100);
		queue.enQueue(200);
		queue.enQueue(300);
		queue.traversalLL();
		queue.deQueue();
		queue.deQueue();
		queue.enQueue(400);
		System.out.println();
		queue.traversalLL();
		
	}

}
