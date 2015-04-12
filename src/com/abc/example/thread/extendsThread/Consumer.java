package com.abc.example.thread.extendsThread;

import java.util.Vector;

public class Consumer extends Thread {
	private final Vector<Integer> sharedData;
    private final int SIZE;

    public Consumer(Vector<Integer> sharedData, int size) {
        this.sharedData = sharedData;
        this.SIZE = size;
    }
    
    public void run() {
        while (true) {
            try {
                while (sharedData.isEmpty()) {
                    synchronized (sharedData) {
                        System.out.println("Queue is empty, consumer is waiting");
                        sharedData.wait();
                    }
                }

                // consume data
                synchronized (sharedData) {
                	sharedData.notifyAll();
                    int data = (Integer) sharedData.remove(0);
                    System.out.print("Cosumed: " + data + "\n");
                }
                Thread.sleep(50);
            } catch (InterruptedException ex) {
            }

        }
    }
}
