package com.abc.example.thread.extendsThread;

import java.util.Vector;
 
public class ProducerConsumerTest {
 
    public static void main(String[] args) {
    	Vector<Integer> sharedData = new Vector<Integer>();
    	int size = 5;
    	
        Thread producer = new Producer(sharedData, size);
        Thread consumer = new Consumer(sharedData, size);
        
        producer.start();
        consumer.start();
    }
}
