package com.abc.example;

import junit.framework.Assert;

import org.junit.Test;

/*
finbonacci 
finbonacci(0) = 0
finbonacci(1) = 1
finbonacci(n) = finbonacci(n-1) + finbonacci(n-2)
 */
public class Fibonacci {
	//recursive
	public static int finbonacci(int n){
		if (n<0)
			return -1;
		if (n == 0 || n==1)
			return n;
		else
			return finbonacci(n-1) + finbonacci(n-2);
		
	}
	
	//0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
	//0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55
	//loop
	public static int fibonacci_forloop(int n) {
		if (n<0)
			return -1;
	    int a = 0;
	    int b = 1;
	    int c = 0;
	    
	    int [] result = new int [n];
	    for (int i = 0; i < n; i++) {
	    	if (i==0 || i==1){
	    		c = 1;
	    		result[i]=i;
	    	}
	    	else{
	    		a=b;
	    		b=c;
	    		c=a+b;
	    		result[i]=c;
	    	}
	    }
	    for (int j = 0; j < n; j++) {
	    	System.out.print(result[j] + " ");
	    }
	    System.out.print("\n");
	    return c;
	}
	
	public static void main(String args[]){
		int n=10;
		System.out.printf("finbonacci of %d = %d\n", n, finbonacci(n));
		
		for (int i=0; i<=10; i++){
			System.out.printf("finbonacci of %d = %d\n", i, finbonacci(i));
			System.out.printf("finbonacci of %d = %d\n", i, fibonacci_forloop(i));
		}
		
		int testdata1 = -1; int expected1 = -1;
		int testdata2 = 0; 	int expected2 = 0;
		int testdata3 = 1;; int expected3 = 1;
		int testdata4 = 10;	int expected4 = 55;
		
		Assert.assertEquals(expected1, finbonacci(testdata1));
		Assert.assertEquals(expected2, finbonacci(testdata2));
		Assert.assertEquals(expected3, finbonacci(testdata3));
		Assert.assertEquals(expected4, finbonacci(testdata4));
	}
	

}
