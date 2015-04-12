package com.abc.example;


/*
double  64
long 	64 	–9,223,372,036,854,775,808 to 9 ,223,372,036,854,775,807
float 	32 	
int 	32 	–2,147,483,648 to 2,147,483,647
short 	16 	– 32,768 to 32,767
char    16
byte 	8 	– 128 to 127
boolean 1 bit
 */
public class StringAndByte {

	public static void main(String[] args){
	String data = "sample data";
	byte[] byteData = data.getBytes();
	
	for (byte b:byteData){
		System.out.print(b+" ");
	}
	
	System.out.print(byteData.toString());
	
	//byte[] b = String.getBytes();
	//byte[] b = String.getBytes(Charset.forName("UTF-8"));


	}
}
