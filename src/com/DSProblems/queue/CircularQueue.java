package com.DSProblems.queue;

import java.util.ArrayList;

public class CircularQueue {

    private int size, front, rear;

    private ArrayList<Integer> queue = new ArrayList<>();


    CircularQueue(int size)
    {
        this.size = size;
        this.front = this.rear = -1;

        for (int i = 0; i < this.size; i++) {
            queue.add(0);
        }
    }

    public void enqueue(Integer data) {
        if(this.isFull()) {
            System.out.println("Queue is full");
            return;
        }
        if(this.isEmpty()) {
            front = 0;
        }
        rear = (rear + 1) % size;
        System.out.println("rear is:::" + rear);
        queue.set(rear, data);
    }

    public Integer dequeue() {
        if (this.isEmpty()) {
            return -1;
        }
        Integer data = queue.get(front);
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front +1 )%size;
        }
        return data;
    }

    private boolean isEmpty() {
        return front == -1;
    }

    private boolean isFull() {
        return (rear +1) % size == front;
    }

    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(5);

        circularQueue.enqueue(10);
        circularQueue.enqueue(20);
        circularQueue.enqueue(30);
        circularQueue.enqueue(40);

        circularQueue.dequeue();
        circularQueue.dequeue();

        circularQueue.enqueue(50);
        circularQueue.enqueue(60);
        circularQueue.enqueue(70);

        circularQueue.enqueue(80);


    }

}
