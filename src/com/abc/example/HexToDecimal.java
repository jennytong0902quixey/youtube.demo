package com.abc.example;

import java.util.Scanner;

/*
Decimal	Hexadecimal
0		0
1		1
2		2
3		3
4		4
5		5
6		6
7		7
8		8
9		9
10		A
11		B
12		C
13		D
14		E
15		F

decimal -> hex: 	String hex = Integer.toHexString(10);
hex -> decimal:   	Integer.parseInt("A", 16);
 */
public class HexToDecimal {
	public static void hexToDecimal() {
		String hexNumber = "A";
		int decimal = Integer.parseInt(hexNumber, 16);
		System.out.println("Hex value is " + decimal);

	}

	public static void decimalToHex() {
		int i = 10;
		String hex = Integer.toHexString(i);
		System.out.println("Hex value is " + hex);
	}

	public static void main(String[] args) {
		String str = "123";
		// int -> string
		int number = Integer.parseInt(str);
		// string -> int
		String numberstr = Integer.toString(number);
		String numberstr2 = String.valueOf(number);
		
		hexToDecimal();
		decimalToHex();

		System.out.print("Hexadecimal Input:");
		// read the hexadecimal input from the console
		Scanner s = new Scanner(System.in);
		String inputHex = s.nextLine();

		try {

			Integer outputDecimal = Integer.parseInt(inputHex, 16);

			System.out.println("Decimal Equivalent : " + outputDecimal);
		} catch (NumberFormatException ne) {
			System.out.println("Invalid Input");
		} finally {
			s.close();

		}
	}

}
