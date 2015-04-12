package com.abc.example;

public class InsertionSort {
	
    private static void printNumbers(int[] input) {
         
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + ", ");
        }
        System.out.println("\n");
    }
 
    public static void insertionSort(int array[]) {
        int size = array.length;
        printNumbers(array);
        
        for (int i = 1; i < size; i++) {
            int key = array[i];
            
            int j = i-1;
            System.out.print("i=" + i + " j=" + j + " key=" + key + "\n");
            while ( (j > -1) && ( key < array [j]) ) {
                array [j+1] = array [j];
                j--;
                printNumbers(array);
            }
            array[j+1] = key;
            printNumbers(array);
        }
    }
    
    public static void main(String[] args) {
        //int[] input = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
    	int[] input = { 10, 9, 8, 7, 6, 6, 4, 3, 2, 1, 0 };
        insertionSort(input);
    }
}
