package com.abc.example;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

//java reverse words in a string
public class ReverseWords {
	public static String reverseWords_token(String s){
		if ( s==null ||  s.length()==1){
			return  s;
		}
		
	    StringTokenizer token = new StringTokenizer(s, " ");
	    
	    Stack<String> stack=new Stack<String>();
	    while(token.hasMoreElements()) {
	        String word = (String)token.nextToken();
	        if(!word.equals("")) 
	        	stack.push(word);
	    }
	    
	    StringBuilder buff=new StringBuilder();
	    while(!stack.isEmpty()){
	        buff.append(stack.pop()); 
	        if(!stack.isEmpty()) 
	        	buff.append(" ");
	    }
	    return buff.toString();
	 }
	
	public static String reverseWords_split(String s) {
		if ( s==null ||  s.length()==1){
			return  s;
		}
		
	    String[] words_array = s.split(" ");
	    Deque<String> deque = new ArrayDeque<String>();
	    
	    for (String word : words_array) {
	        if (!word.equals("")) {
	        	deque.addFirst(word);
	        }
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    while (!deque.isEmpty()) {
	    	sb.append(deque.removeFirst());
	        if (!deque.isEmpty()) {
	        	sb.append(" ");
	        }
	    }
	    return sb.toString();
	}
	
	public static String reverse_jenny(String s){
		if ( s==null ||  s.length()==1){
			return  s;
		}
		
		s = s.trim();
		//"  Hi my name is person!"
		Stack<String> stack=new Stack<String>();
		char prechar = 0;
		StringBuffer sb = new StringBuffer();
		for (int i=0; i<= s.length()-1; i++){
			if ( s.charAt(i) == ' ' ){
				if (prechar == ' ')
					continue;
				if (prechar != ' ' && sb.length()!=0){
					stack.push(sb.toString());
					sb = new StringBuffer();
				}
				stack.push(" ");
			}
			else{
				sb.append( s.charAt(i));
			}
			prechar = s.charAt(i);
			if (i ==  s.length()-1){
				stack.push(sb.toString());
			}
		}
		
		StringBuilder buff=new StringBuilder();
		while(!stack.isEmpty()){
	        buff.append(stack.pop()); 
	    }
	    return buff.toString();
	}
	
	public static void main(String[] args) {
		String testString = "  Hi my   name is person!  ";
		
		System.out.println(reverseWords_token(testString));  
		System.out.println(reverseWords_split(testString));  
	    System.out.println(reverse_jenny(testString));  
	}
}
