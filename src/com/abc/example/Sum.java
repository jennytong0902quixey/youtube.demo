package com.abc.example;
import org.junit.Assert;
import org.junit.Test;

public class Sum {
	public static void print (int[] values){
		for (int i=0; i<values.length; i++){
			System.out.print(values[i] + ",");
		}
		System.out.print("\n");
	}
	
	/*
	 * Write a function what will return the sum of the two biggest elements in an array,
	 * or Integer.MIN_VALUE if the calculatino can not be peformaed.
	 */
	public static int sum (int[] values){
		if (values == null){
			return Integer.MIN_VALUE;
		}
		print(values);
		
		int max1=0;
		int max2=0;
		int size = values.length;
		if (size<2)
			return Integer.MIN_VALUE;
		
		for (int pass=0; pass<2; pass++){
			for (int i=0; i<values.length-1; i++){
				if (values[i] > values[i+1]){
					int tmp = values[i];
					values[i] = values[i+1]; 
					values[i+1] = tmp;
				}
				if (pass == 0)
					max1=values[i+1];
				if (pass == 1)
					max2=values[i]; 
			}
		}
		print(values);
		return max1+max2;
	}

	
	@Test
	public void test_sum(){
		int[] input0 = null;
		int[] input1 = {};
		int[] input2 = {5};
		int[] input3 = {56, 12, 6, 44, 0, 11};
		
		Assert.assertEquals(Integer.MIN_VALUE, sum(input1));
		Assert.assertEquals(Integer.MIN_VALUE, sum(input2));
		Assert.assertEquals(100, sum(input3));
	}
	
	public static void main(String a[]){
		int[] input0 = null;
		int[] input1 = {};
		int[] input2 = {5};
		int[] input3 = {56, 12, 6, 44, 0, 11};
		
		int value = sum(input3);
		System.out.print(value);
		
		Assert.assertEquals(Integer.MIN_VALUE, sum(input0));
		Assert.assertEquals(Integer.MIN_VALUE, sum(input1));
		Assert.assertEquals(Integer.MIN_VALUE, sum(input2));
		Assert.assertEquals(100, sum(input3));
	}
}
