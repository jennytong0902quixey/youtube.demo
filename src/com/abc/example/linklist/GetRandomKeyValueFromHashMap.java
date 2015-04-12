package com.abc.example.linklist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class GetRandomKeyValueFromHashMap {
	public static void main(String[] args) {
		
		HashMap<String, String> companies = new HashMap<String, String>();
		
		companies.put("eBay", 	"South San Jose");
		companies.put("Paypal", "North San Jose");
		companies.put("Google", "Mountain View");
		companies.put("Yahoo", 	"Santa Clara");
		companies.put("Twitter", "San Francisco");

		// Get a random entry from the HashMap.
		Object[] keys = companies.keySet().toArray();
		Object key = keys[new Random().nextInt(keys.length)];
		
		System.out.println("Random Value: \n" + key + " :: " + companies.get(key));

		List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(companies.entrySet());

		// Bonus Crunchify Tips: How to Shuffle a List??
		// Each time you get a different order...
		
		System.out.println("\nNow Let's start shuffling list");
		Collections.shuffle(list);
		for (Map.Entry<String, String> entry : list) {
			System.out.println(entry.getKey() + " :: " + entry.getValue());
		}
	}
}
