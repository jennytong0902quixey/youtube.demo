package com.abc.example.thread.implementsRunnable;

import java.util.Vector;

public class ProducerConsumerTest {

	public static void main(String args[]) {
		Vector<Integer> sharedData = new Vector<Integer>();
		int size = 5;

		Thread producer = new Thread(new Producer(sharedData, size), "Producer");
		Thread consumer = new Thread(new Consumer(sharedData, size), "Consumer");

		producer.start();
		consumer.start();
	}
}
