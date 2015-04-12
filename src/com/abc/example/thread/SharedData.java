package com.abc.example.thread;

class SharedData {
	   private int data;
	   private boolean available = false;
	   
	   public synchronized int get() {
	      while (available == false) {
	         try {
	            wait();
	         }
	         catch (InterruptedException e) {
	         }
	      }
	      available = false;
	      notifyAll();
	      return data;
	   }
	   
	   public synchronized void put(int value) {
	      while (available == true) {
	         try {
	            wait();
	         }
	         catch (InterruptedException e) { 
	         } 
	      }
	      data = value;
	      available = true;
	      notifyAll();
	   }
	}
