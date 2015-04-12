package com.abc.example;

public class Print {
	public static void printArray(double [] array){
		StringBuffer bf = new StringBuffer();
		for (int i=0; i<array.length; i++){
			bf.append(array[i]);
			bf.append(", ");
		}
		System.out.print(bf.toString());
	}
	
	public static void main(String args[]){
		double[] test = {0.5, 3.4, 123.0};
		printArray(test);
	}
}
