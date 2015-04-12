package com.abc.example;

public class StringManipulate {
	
	public static String convertUpper(String str){
	 StringBuilder sb = new StringBuilder();
		for (int i=0; i<str.length(); i++){
			char c = str.charAt(i);
			if (c >='a' && c <='z'){
				c= (char)(c -'a' +'A');
			}
			sb.append(c);
		}
		return sb.toString();
	}
	
	public static String convertLower(String str){
		 StringBuilder sb = new StringBuilder();
			for (int i=0; i<str.length(); i++){
				char c = str.charAt(i);
				if (c >='A' && c <='Z'){
					c= (char)(c +'a' -'A');
				}
				sb.append(c);
			}
			return sb.toString();
	}
	
	public static int findStringLength(String str){
		int i=0;
		while (str.charAt(i)!='\0'){
			++i;
		}
		return i;
	}
	
	public static boolean stringcmp(String str1, String str2){
		int size1 = str1.length();
		int size2 = str2.length();
		
		if (size1 !=size2)
			return false;
		else{
			for (int i=0; i<size1; i++){
				if (str1.charAt(i) != str2.charAt(i))
					return false;
			}
			return true;
		}
	}
	
	//convert string 123 to int 123
	public static int atoi(String str){
		if(str == null)
			return -1;
		int n = 0;
		
		for (int i=0; i<str.length(); i++){
			if (str.charAt(i)>'0' && str.charAt(i)<'9'){
				n = 10 * n + (str.charAt(i) - '0'); 
			}
			else{
				System.out.print("Can not atoi for non-all-number string.");
				return -1;
			}
		}
		return n;
	}
	
	public static int stringToInteger(String str){
		return Integer.parseInt(str);
	}
	
	public static String IntegerToString(int number){
		String numb = Integer.toString(number);
		numb = String.valueOf(number);
		return numb;
	}
	
	public static void main(String args[]){
		String str = "this IS a Test";
		System.out.print(convertUpper(str)+"\n");
		System.out.print(convertLower(str));
		
		//System.out.print(findStringLength(str));
		
		String str1 = "this IS a Test";
		String str2 = "this IS a Test";
		String str3 = "this IS a";
		String str4 = "this IS a TesT";
		System.out.print("\n" + stringcmp(str, str2));
		System.out.print("\n" + stringcmp(str, str3));
		System.out.print("\n" + stringcmp(str, str4));
		
		System.out.print("\n" +atoi("123"));
		System.out.print("\n" +atoi("1s23"));
	}
}
