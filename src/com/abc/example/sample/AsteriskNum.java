package com.abc.example.sample;

public class AsteriskNum {
	public static final String asteriskNum = "16506444501";
	
	public AsteriskNum(){
	
	for (int i=0; i< asteriskNum.length(); i++){
    	StringBuffer button = new StringBuffer("button");
		String number = button.append(asteriskNum.valueOf(i)).toString();
		System.out.print(number);
    }   
	}

}