package com.abc.example.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Hashset: no duplicate allowed
//TreeMap: sorted

public class FindLongestSubString {

	public static void FindLongestSubString(String str) {
		Set<String> subStr = new HashSet<String>();
		Map<Integer, String> hashMap = new HashMap<Integer, String>();

		int position = 0;
		int len = 0;
		int size = str.length();
		for (int i = 0; i < size; i++) {
			if (!subStr.add(String.valueOf(str.charAt(i)))) {
				String tmp = str.substring(position, i);
				System.out.print(tmp+"\n");
				len = i - position;
				position = i;
				hashMap.put(len, tmp);
				
				i = i - 1;
				subStr = new HashSet<String>();
			}
		}
		String tmp = str.substring(position, size);
		System.out.print(tmp+"\n");
		len = size - position;
		hashMap.put(len, tmp);
		System.out.print("\n");
		
		for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
			Integer key = entry.getKey();
			String value = entry.getValue();

			System.out.println(key + " => " + value);
		}
	}

	public static void main(String[] args) {
		String testString = "java2novice";
		//FindLongestSubString(testString);
		FindLongestSubString("java_language_is_sweet");
	}

}
