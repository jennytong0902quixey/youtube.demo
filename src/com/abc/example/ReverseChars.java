package com.abc.example;
import org.junit.Assert;
import org.junit.Test;


//buble sort
//java reverse words in a string
//implement hash table
//link list
//stack
public class ReverseChars {
	
	public static String reverse_reverse(String str){
		if (str==null || str.length()==1){
			return str;
		}
		return new StringBuffer(str).reverse().toString();
	}
	
	public String reverse_recursive(String str){
		if (str==null || str.length()==1){
			return str;
		}
		return reverse_recursive(str.substring(1)) + str.charAt(0);
	}
	
	public static String reverseSwap(String str){
		if (str==null || str.length()==1){
			return str;
		}
		
		char[] chars = str.toCharArray();
		int right = chars.length -1;
		
		for (int left=0; left<right; left++){
			char swap = chars[left];
			chars[left] = chars[right];
			//chars[right--] = swap;
			chars[right] = swap;
			right--;
		}
		return new String(chars);
	}
    
	// too complicated
	public static String reverse_swap(String str){
		if (str==null || str.length()==1){
			return str;
		}
		
		StringBuffer result = new StringBuffer(str);
		
		for (int i=0; i<str.length()/2; i++){
			int swapIndex = str.length()-1 - i;
			char swap = result.charAt(swapIndex);
			result.setCharAt(swapIndex, result.charAt(i));
			result.setCharAt(i, swap);
		}
		return result.toString();
	}

	public static void main(String args[]){
		String test_str1 = null;
		String test_str2 = "";
		String test_str3 = "this is a test";
		String expected_result = "tset a si siht";
		
		Assert.assertNull(reverse_swap(test_str1));
		Assert.assertEquals(0, reverse_swap(test_str2).length());
		Assert.assertEquals(expected_result, reverse_swap(test_str3));
		reverse_reverse(test_str3);
		System.out.print(reverseSwap(test_str3));
	}

}
