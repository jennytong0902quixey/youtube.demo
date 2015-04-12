package com.abc.example.thread.extendsThread;

import java.util.Vector;

public class Producer extends Thread {
	private final Vector<Integer> sharedData;
    private final int SIZE;

    public Producer(Vector<Integer> sharedData, int size) {
        this.sharedData = sharedData;
        this.SIZE = size;
    }
    
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Produced: " + i);
            
            try {
	            while (sharedData.size() == SIZE) {
	            	
	                synchronized (sharedData) {
	                	System.out.println("Queue is full, producer is waiting.");
	                    sharedData.wait();
	                }
	            }
	
	            // produce data
	            synchronized (sharedData) {
	            	sharedData.add(i);
	            	sharedData.notifyAll();
	            }
            } catch (InterruptedException e) {
			}
        }
    }
}
