package com.abc.example.linklist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public class CommonFunctions {
	
	public static void exampleHashSet(){
		Integer[] numbers = { 7, 7, 8, 9, 10, 8, 8, 9, 6, 5, 4 };
		List<Integer> list = Arrays.asList(numbers); // no need cast
		for (Integer number : list)
			System.out.println("strNumber: " + number);
		System.out.println("\n");

		//HashSet: no duplicate
		Set<Integer> set = new HashSet<Integer>(list);
		String strNumber = set.toString();
		System.out.println("strNumber: " + strNumber);
		System.out.println("\n");
		
		Iterator iterator = set.iterator();
		while(iterator.hasNext())
			System.out.println("strNumber: " + iterator.next());
		System.out.println("\n");
	}
	
	public static void exampleHashMap(){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("eBay", 	"South San Jose");
		map.put("Paypal",   "North San Jose");
		map.put("Google",   "Mountain View");
		map.put("Yahoo", 	"Santa Clara");
		map.put("Twitter",  "San Francisco");
		
		System.out.print("keys: ");
		Collection<String> keySet = map.keySet();
		Iterator iterator = keySet.iterator();
		while(iterator.hasNext())
			System.out.print(iterator.next() + ", ");
		
		System.out.print("\nvalues: ");
		Collection<String> values = map.values();
		iterator = values.iterator();
		while(iterator.hasNext())
			System.out.print(iterator.next() + ", ");
		
		System.out.print("\n\nentry set: ");
		List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(map.entrySet());
		iterator = list.iterator();
		while(iterator.hasNext())
			System.out.print(iterator.next() + ", ");
		
		System.out.print("\n\nentry set(K, V): ");
		for (Map.Entry<String, String> entry : list) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}

		// Get a random entry from the HashMap.
		Object[] keys = map.keySet().toArray();
		Object key = keys[new Random().nextInt(keys.length)];
		String keyValue = map.get(key);
		System.out.println("Random Value: " + key + ":" + keyValue);

		List<Map.Entry<String, String>> list2 = new ArrayList<Map.Entry<String, String>>(map.entrySet());

		System.out.println("\nNow Let's start shuffling list");
		Collections.shuffle(list2);
		for (Map.Entry<String, String> entry : list2) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}

	public static void main(String[] args){
		exampleHashSet();
		exampleHashMap();
	}
}

/*
strNumber: 7
strNumber: 7
strNumber: 8
strNumber: 9
strNumber: 10
strNumber: 8
strNumber: 8
strNumber: 9
strNumber: 6
strNumber: 5
strNumber: 4

strNumber: [4, 5, 6, 7, 8, 9, 10]

strNumber: 4
strNumber: 5
strNumber: 6
strNumber: 7
strNumber: 8
strNumber: 9
strNumber: 10

keys: Paypal, Google, Yahoo, Twitter, eBay, 
values: North San Jose, Mountain View, Santa Clara, San Francisco, South San Jose, 

entry set: Paypal=North San Jose, Google=Mountain View, Yahoo=Santa Clara, Twitter=San Francisco, eBay=South San Jose, 

entry set(K, V): Paypal:North San Jose
Google:Mountain View
Yahoo:Santa Clara
Twitter:San Francisco
eBay:South San Jose
Random Value: Paypal:North San Jose

Now Let's start shuffling list
eBay:South San Jose
Paypal:North San Jose
Google:Mountain View
Twitter:San Francisco
Yahoo:Santa Clara
*/