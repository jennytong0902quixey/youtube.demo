package com.abc.example.linklist;

import java.util.NoSuchElementException;

public class Queue {
    private Object[] array;
    private int size = 0;
    private int head = 0;
    private int tail = 0;

    public Queue(int capacity) {
        array = new Object[capacity];
    }

    public void enqueue(Object item) {
        if (size == array.length) {
            throw new IllegalStateException("Cannot add to full queue");
        }
        array[tail] = item;
        tail = (tail + 1) % array.length;
        System.out.print("tail: " + tail + "\n");
        size++;
    }

    public Object dequeue() {
        if (size == 0) {
            throw new NoSuchElementException("Cannot remove from empty queue");
        }
        Object item = array[head];
        array[head] = null;
        head = (head + 1) % array.length;
        System.out.print("head: " + head + "\n");
        size--;
        return item;
    }

    public Object peek() {
        if (size == 0) {
            throw new NoSuchElementException("Cannot peek into empty queue");
        }
        return array[size - 1];
        //return array[head];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
    
    public static void main(String[] args) {
    	Queue theQueue = new Queue(7);
		theQueue.enqueue(10);
		theQueue.enqueue(20);
		theQueue.enqueue(30);
		theQueue.enqueue(40);
		theQueue.enqueue(50);
		theQueue.enqueue(60);
		theQueue.enqueue(70);
		
		System.out.println(theQueue.peek());
		
		while (!theQueue.isEmpty()) {
			int value = (Integer) theQueue.dequeue();
			System.out.print(value);
			System.out.print(" ");
		}
		System.out.println("");
	}
}
