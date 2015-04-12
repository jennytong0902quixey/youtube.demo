package com.abc.example;

import java.util.ArrayList;
import java.util.List;

//Program: Find out duplicate number between 1 to N numbers.
//See more at: http://www.java2novice.com/java-interview-programs/duplicate-number/#sthash.chELwOXW.dpuf

//http://www.java2novice.com/java-interview-programs/find-middle-index/
public class DuplicateNumber {
 
    public static int findDuplicateNumber(List<Integer> numbers){
         
        int highestNumber = numbers.size() - 1;
        System.out.println("highestNumber:" + highestNumber);
        
        int total = getSum(numbers);
        System.out.println("total:" + total);
        
        int highestNumber_plus_one = highestNumber+1;
        
        //only works for consecutive numbers 1, 2, 3, 4, 5
        int calculation = highestNumber*(highestNumber_plus_one)/2;
        
        int duplicate = total - calculation;
        
        return duplicate;
    }
     
    public static int getSum(List<Integer> numbers){
         
        int sum = 0;
        for(int num:numbers){
            sum += num;
        }
        return sum;
    }
     
    public static void main(String a[]){
        List<Integer> numbers = new ArrayList<Integer>();
        
        for(int i=1;i<56;i++){
            numbers.add(i);
        }
        //add duplicate number into the list
        numbers.add(1);
        System.out.println("Duplicate Number: "+ findDuplicateNumber(numbers));
    }
}

