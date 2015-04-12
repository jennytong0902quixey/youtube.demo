package com.abc.example.hashtable;

/*
Hashtable implementation in JAVA
How to implement hashtable in java using Array.

The Hashtable stores key value pair and the retrieval and insert of element time complexity is O(1).
To store the elements in hashtable there is need to calculate hashkey which is use to store value at specific index on array. 
The function "hash" in program calculates the hash code, once the hash code is calculated modulo is taken by the size of Array 
to map the key at particular index of the array. remember to minimize collision take size at prime number.

There are possibility of collision on elements at particular index if the hash value calculated same 
for the two different key and hence the old value will be over written in by new value. 
To avoid this situation there are multiple way to implement the logic but here we are avoiding this logic. 
We will focus how hashtable interal structure and how does it works. 

*/
public class MyHashTable<K, V> {

	/* take the capacity as prime number to reduce the collision */
	private static int SIZE = 31;

	/* initialize array to store value */
	private V[] tableValues = (V[]) new Object[SIZE];

	public synchronized V put(K key, V value) {
		if (value == null) {
			throw new NullPointerException();
		}

		int index = hash(key.hashCode()) % SIZE;

		tableValues[index] = value;
		return value;
	}

	public synchronized V get(K key) {

		int index = hash(key.hashCode()) % SIZE;
		return tableValues[index];
	}

	/**
	 * method calculates the hash code
	 */

	private synchronized int hash(int h) {
		h ^= (h >>> 20) ^ (h >>> 12);
		return h ^ (h >>> 7) ^ (h >>> 4);
	}

	public static void main(String arg[]) {

		MyHashTable<String, String> table = new MyHashTable<String, String>();

		/* store 10 values in Hashtable */
		for (int i = 0; i < 10; i++) {
			table.put("key" + i, "value" + i);
			System.out.println("key" + i + ": " + table.get("key" + i));
		}

		/* retrive values */
		for (int i = 0; i < 10; i++) {
			System.out.println(table.get("key" + i));
		}
	}

}



