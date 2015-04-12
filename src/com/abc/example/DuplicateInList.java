package com.abc.example;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class DuplicateInList {
	
	public static Set<String> findDuplicates(List<String> listContainingDuplicates) {
		
		final Set<String> dupNotAllowed = new HashSet<String>();
		final Set<String> duplicated = new HashSet<String>();

		for (String item : listContainingDuplicates) {
			if (!dupNotAllowed.add(item)) {
				duplicated.add(item);
			}
		}
		return duplicated;
	}

	public static void main(String[] args) {
		List<String> list = new LinkedList<String>();
		
		for (int i = 0; i < 10; i++) {
			list.add(String.valueOf(i));
		}
		for (int i = 0; i < 5; i++) {
			list.add(String.valueOf(i));
		}

		System.out.println("My List : " + list);
		System.out.println("\nHere are the duplicate elements from list : " + findDuplicates(list));
	}

}

/*
Given a sorted array with duplicates and a number, find the range in the
  * form of (startIndex, endIndex) of that number. For example,
  * find_range({0 2 3 3 3 10 10},  3) should return (2,4).
  * find_range({0 2 3 3 3 10 10},  6) should return (-1,-1).
  * The array and the number of duplicates can be large.

int[] findRange(int[] values, int value)
{
    Set<String> dupNotAllowed = new HashSet<String>;
    Set<String> duplicated = new HashSet<String>;
    int startIndex;
    int endIndex;
    
    for (int i=0; i,values.length; i++){
        String strValue = Integer.parseIn(values(i));
        if (startIndex !=-1)
                startIndex = i;
            endIndex = i;    
        
}
//({0 2 3 3 3 10 10},  3)
i=0; value = 0; not found
1=1; value = 2; not found
i=2; value = 3; found save i to startIndex=2, endInex=2
i=3; value = 3; found startIndex=2, endInex=3
i=4; value = 3; found startIndex=2, endInex=4
i=5; value = 10; not found startIndex=2, endInex=4
i=6; value = 10; not found startIndex=2, endInex=4

O(n) slow search
binary search O(n/2)
array[middle] 

int[] findRange(int[] values, int value){

    if (values.length ==0)
        return -1;
    int startIndex=-1;
    int endIndex=-1;
    
    for (int i=0; i<values.length; i++){
        if (values[i] == value){
            if (startIndex !=-1)
                startIndex = i;
            endIndex = i;
        }
        System.out.print("startIndex "+startIndex + "endIndex" + endIndex);

    } 
}

public void test_findRange(){
    int[] testdata = {0 2 3 3 3 10 10};
    int key = 3;
    int expectedStartIndex =2;
    int expoectedEndIndex =4;
    
    
    Assert.asssertEqual(expectedStartIdex, fiindRange()[0]}
    
    
}
Steps

test cases

0 2 4  - 2

test1: 0 4, 4, 8 -> 1, 2 pass
test2: c, a, 4, 4, -> -1 fail
test3: empty array, 4 -> -1 fail
test4: -1, -2, 6 -> fail
test5 null -> fail
test6 *, $, +, 0, 2, 2, -> fail


*/
