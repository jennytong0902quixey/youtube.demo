package com.abc.example.thread;

class Producer extends Thread {
	private SharedData sharedData;
	private int number;

	public Producer(SharedData c, int number) {
		sharedData = c;
		this.number = number;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			sharedData.put(i);
			System.out.println("Producer #" + this.number + " put: " + i);
			try {
				sleep((int) (Math.random() * 100));
			} catch (InterruptedException e) {
			}
		}
	}
}
