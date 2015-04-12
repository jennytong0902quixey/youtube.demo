package com.abc.example;

import java.util.*;

public class BitManipulate {
	public static void sumOfPrimeNumber(int d) {
		int sum = 0;
		for (int i = 0; i < d; i++) {
			if (checkPrimeNumber(i)) {
				sum += i;
			}
		}
		System.out.print("sum=" + sum);
	}

	public static boolean checkPrimeNumber(int d) {
		BitSet bitSet = new BitSet(1024);
		int size = bitSet.size();

		for (int i = 0; i < size; i++) {
			bitSet.set(i);
		}

		int finalBit = (int) Math.sqrt(size);
		for (int i = 2; i < finalBit; i++) {
			if (bitSet.get(i)) {
				for (int j = 2 * i; j < size; j += i)
					bitSet.clear(j);
			}
		}

		if (bitSet.get(d)) {
			// System.out.print(d + " is prime number\n");
			return true;
		} else {
			// System.out.print(d + " is NOT prime number\n");
			return false;
		}
	}

	public static long sumOfPrimeNumber2(int d) {
		int count = 0;
		long sum = 0;

		while (count < d) {
			if (isPrimeNumber(count)) {
				sum += count;
			}
			count++;
		}
		System.out.println("\nsum=" + sum);
		return sum;
	}

	//prime number can be only divided by itself
	private static boolean isPrimeNumber(int number) {
		for (int i = 2; i <= number / 2; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	
	public static void bitOperatoration(int d1, int d2) {
		System.out.print(" \n& AND operator:\n");
		getBits(d1);
		getBits(d2);
		getBits(d1 & d2);

		System.out.print(" \n| OR operator:\n");
		getBits(d1);
		getBits(d2);
		getBits(d1 | d2);

		System.out.print(" \n^ XOR operator:\n");
		getBits(d1);
		getBits(d2);
		getBits(d1 ^ d2);

		System.out.print(" \n~ complement operator:\n");
		getBits(d1);
		getBits(~d1);

		getBits(d2);
		getBits(~d2);

		System.out.print(" \n<< left shift operator:\n");
		getBits(d1);
		getBits(d1 << 2);

		getBits(d2);
		getBits(d2 << 2);

		System.out
				.print(" \n>> right shift with sign operator: (for sign(-1): drop rightside bits, add 1 leftside)\n");
		getBits(d1);
		getBits(d1 >> 2);

		getBits(d2);
		getBits(d2 >> 2);

		/*
		 * System.out.print(" \n<<< left shift with zero extensioin operator:\n")
		 * ; getBits(d1); //getBits( d1<<<2);
		 * 
		 * getBits(d2); getBits( d2<<<2);
		 */

		System.out
				.print(" \n>>> right shift with zero extensioin operator: (for sign(-1): drop rightside bits, add 0 leftside)\n");
		getBits(d1);
		getBits(d1 >>> 2);

		getBits(d2);
		getBits(d2 >>> 2);
	}

	public static String getBits(int value) {
		int intvalue = value;
		int displayMask = 1 << 31;
		StringBuffer sb = new StringBuffer(35);

		for (int i = 1; i <= 32; i++) {
			char c = ((value & displayMask) == 0) ? '0' : '1';
			sb.append(c);

			value = value << 1;

			if (i % 8 == 0)
				sb.append(" ");
		}
		String bitString = sb.toString();

		System.out.print(bitString + "(" + intvalue + ")\n");
		return bitString;
	}
	
	public void stringToByte(){
		String data = "sample data";
		byte[] byteData = data.getBytes();
		
		for (byte b:byteData){
			System.out.print(b+" ");
		}
		
		System.out.print(byteData.toString());
	}

	public static void main(String[] args) {
		getBits(5);
		getBits(-1);

		bitOperatoration(8, -8);

		int value = 5;
		if (checkPrimeNumber(value))
			System.out.print(value + " is prime number\n");
		else
			System.out.print(value + " is prime number\n");

		sumOfPrimeNumber(1000);
		sumOfPrimeNumber2(1000);
	}
}

/*
 * byte: 8 char, short: 16 int, float: 32 long, double: 64
 * 
 * bitwise AND operator: 0 0 0 1 0 0 0 1 0 1 1 1
 * 
 * bitwise inclusive OR operator: 0 0 0 1 0 1 0 1 1 1 1 1
 * 
 * bitwise exclusive XOR(^) operator: 0 0 0 1 0 1 0 1 1 1 1 0
 * 
 * 00000000 00000000 00000000 00000101 (5) 11111111 11111111 11111111 11111111
 * (-1)
 * 
 * & AND operator: 00000000 00000000 00000000 00001000 (8) 11111111 11111111
 * 11111111 11111000 (-8) 00000000 00000000 00000000 00001000 (8)
 * 
 * | OR operator: 00000000 00000000 00000000 00001000 (8) 11111111 11111111
 * 11111111 11111000 (-8) 11111111 11111111 11111111 11111000 (-8)
 * 
 * ^ XOR operator: 00000000 00000000 00000000 00001000 (8) 11111111 11111111
 * 11111111 11111000 (-8) 11111111 11111111 11111111 11110000 (-16)
 * 
 * ~ complement operator: 00000000 00000000 00000000 00001000 (8) 11111111
 * 11111111 11111111 11110111 (-9) 11111111 11111111 11111111 11111000 (-8)
 * 00000000 00000000 00000000 00000111 (7)
 * 
 * << left shift operator: 00000000 00000000 00000000 00001000 (8) 00000000
 * 00000000 00000000 00100000 (32) 11111111 11111111 11111111 11111000 (-8)
 * 11111111 11111111 11111111 11100000 (-32)
 * 
 * >> right shift with sign operator: (for sign(-1): drop rightside bits, add 1
 * leftside) 00000000 00000000 00000000 00001000 (8) 00000000 00000000 00000000
 * 00000010 (2) 11111111 11111111 11111111 11111000 (-8) 11111111 11111111
 * 11111111 11111110 (-2)
 * 
 * >>> right shift with zero extensioin operator: (for sign(-1): drop rightside
 * bits, add 0 leftside) 00000000 00000000 00000000 00001000 (8) 00000000
 * 00000000 00000000 00000010 (2) 11111111 11111111 11111111 11111000 (-8)
 * 00111111 11111111 11111111 11111110 (1073741822)
 */
