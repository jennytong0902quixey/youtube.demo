package com.abc.example.hashtable.chaining;

public class HashMap {

	private final static int TABLE_SIZE = 128;
	LinkedHashEntry[] table;

	public HashMap() {
		table = new LinkedHashEntry[TABLE_SIZE];

		for (int i = 0; i < TABLE_SIZE; i++)
			table[i] = null;
	}

	/**
	 * method calculates the hash code
	 */

	private synchronized int hash(int h) {
		h ^= (h >>> 20) ^ (h >>> 12);
		return h ^ (h >>> 7) ^ (h >>> 4);
	}

	public int get(int key) {

		int hash = (key % TABLE_SIZE);

		if (table[hash] == null)
			return -1;
		else {
			LinkedHashEntry entry = table[hash];
			while (entry != null && entry.getKey() != key)
				entry = entry.getNext();

			if (entry == null)
				return -1;
			else
				return entry.getValue();
		}
	}

	public void put(int key, int value) {
		int hash = (key % TABLE_SIZE);

		if (table[hash] == null)
			table[hash] = new LinkedHashEntry(key, value);
		else {
			LinkedHashEntry entry = table[hash];
			while (entry.getNext() != null && entry.getKey() != key)
				entry = entry.getNext();

			if (entry.getKey() == key)
				entry.setValue(value);
			else
				entry.setNext(new LinkedHashEntry(key, value));
		}
	}

	public void remove(int key) {
		int hash = (key % TABLE_SIZE);

		if (table[hash] != null) {
			LinkedHashEntry prevEntry = null;
			LinkedHashEntry entry = table[hash];

			while (entry.getNext() != null && entry.getKey() != key) {
				prevEntry = entry;
				entry = entry.getNext();
			}

			if (entry.getKey() == key) {
				if (prevEntry == null)
					table[hash] = entry.getNext();
				else
					prevEntry.setNext(entry.getNext());
			}
		}
	}

	public static void main(String args[]) {
		// Create a hash map
		HashMap balance = new HashMap();
		int values;
		String str;
		double bal;

		balance.put(3434, 3434);
		balance.put(3434, 343412);
		balance.put(2323, 2323);
		balance.put(1212, 1212);
		balance.put(4545, 4545);

		values = balance.get(3434);
		System.out.print(values);
	}
}
