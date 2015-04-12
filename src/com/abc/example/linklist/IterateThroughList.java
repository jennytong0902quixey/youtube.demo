package com.abc.example.linklist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class IterateThroughList {

	public static void main(String[] argv) {

		// create list
		List<String> list = new ArrayList<String>();

		// add 4 different values to list
		list.add("eBay");
		list.add("Paypal");
		list.add("Google");
		list.add("Yahoo");

		// iterate via "for loop"
		System.out.println("==> For Loop Example.");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		// iterate via "New way to loop"
		System.out.println("\n==> Advance For Loop Example..");
		for (String temp : list) {
			System.out.println(temp);
		}

		// iterate via "iterator loop"
		System.out.println("\n==> Iterator Example...");
		Iterator<String> CrunchifyIterator = list.iterator();
		while (CrunchifyIterator.hasNext()) {
			System.out.println(CrunchifyIterator.next());
		}

		// iterate via "while loop"
		System.out.println("\n==> While Loop Example....");
		int i = 0;
		while (i < list.size()) {
			System.out.println(list.get(i));
			i++;
		}
	}
}
