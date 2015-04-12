package com.abc.example;

import java.util.ArrayList;
import java.util.Collections;

public class RemoveFromArrayList {
	
	public static void printList(ArrayList<Integer> values){
		for (int i=0; i<values.size(); i++){
			System.out.print(values.get(i) + ",");
		}
		System.out.print( "\n");
	}
	
	/*
	 * Write a function that will remove the values below a certain value from an ArrayList of
	 * integers
	 * How would you do it without creating a new ArrayList?
	 * How does the ArrayList internally remove the elements
	 */
	public static ArrayList<Integer> removeSmallValues(ArrayList<Integer> values, int minValue){
		printList(values);
		Collections.sort(values);
		printList(values);
		int n=values.size();
		
		while (n>0){
			int tmp = 0;
			for (Integer data : values){
				if (data.intValue() <= minValue ){
					tmp = data.intValue();
					break;
				}
			}
			values.remove(Integer.valueOf(tmp));
			n--;
		}
		
		printList(values);
		return values;
	}

	
	public static void main(String args[]){
		ArrayList<Integer> data = new ArrayList<Integer>();

		for (int i=10; i>0; i--){ 
			data.add(new Integer(i));
		}
		removeSmallValues(data, 8);
	}
}
