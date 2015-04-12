package com.abc.example.linklist;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Crunchify.com
 */

public class ArraysToSet {

	public static void main(String[] args) {
		Integer[] numbers = { 7, 7, 8, 9, 10, 8, 8, 9, 6, 5, 4 };

		Set<Integer> set = new HashSet<Integer>(Arrays.asList(numbers));
		String strNumber = set.toString();
		System.out.println("Print Set Value via toString(): " + strNumber);

		System.out.println("\nPrint Set Value via Iterator: ");
		Iterator<Integer> iterator = set.iterator();
		while ( iterator.hasNext()) {
			Object o = iterator.next();
			System.out.print(o + " ");
		}
	}
}
