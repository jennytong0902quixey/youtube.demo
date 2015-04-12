package com.abc.example;

import java.util.Stack;

public class BinaryToDecimal {
 
    public static int binaryToDecimal(int binary){
        int decimal = 0;
        int power = 0;
        
        while(true){
            if(binary == 0){
                break;
            } else {
                int tmp = binary%10;
                
                decimal += tmp*Math.pow(2, power);
                binary = binary/10;
                power++;
            }
        }
        return decimal;
    }
    
    public static int decimaltoBinary(int decimal){
    	
        Stack<Integer> sk = new Stack<Integer>();
        while(true){
            if(decimal == 0 || decimal == 1){
            	sk.push(decimal);
                break;
            } else {
                int tmp = decimal%2;
                sk.push(tmp);
                decimal = decimal/2;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!sk.isEmpty()){
        	sb.append(sk.pop());
        }
        String tmp2 = sb.toString();
        int binary = Integer.parseInt(tmp2);
        return binary;
    }
     
    public static void main(String a[]){
        System.out.println("11 ===> "+binaryToDecimal(11));
        System.out.println("110 ===> "+binaryToDecimal(110));
        System.out.println("100110 ===> "+binaryToDecimal(100110));
        
        System.out.println("38 ===> "+decimaltoBinary(38));
    }
}

/*
100110 ===> 38
38 ===> 100110
 */
