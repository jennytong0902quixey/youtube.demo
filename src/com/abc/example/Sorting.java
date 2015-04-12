package com.abc.example;

public class Sorting {

	private static void printNumbers(int[] input) {
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + ", ");
		}
		System.out.println("\n");
	}

	public static int[] bubble_sort(int array[]) {
		for (int i = 0; i < array.length - 1; i++) {
			// printNumbers(array);
			for (int j = 0; j < array.length - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp;
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		// printNumbers(array);
		return array;
	}

	/*
	 * Given 2 unsorted array, how would you sort them into a single array
	 */
	public static int bubble(int array1[], int array2[]) {
		int size1 = array1.length;
		int size2 = array2.length;
		int size = size1 + size2;
		int[] data = new int[size];

		for (int i = 0; i < size; i++) {
			if (i < array1.length) {
				data[i] = array1[i];
			} else {
				data[i] = array2[i - size2];
			}
		}
		printNumbers(data);

		int tmp = 0;
		for (int i = 0; i < size - 1; i++) {
			for (int j = 0; j < size - 1; j++) {
				if (data[j] > data[j + 1]) {
					tmp = data[j];
					data[j] = data[j + 1];
					data[j + 1] = tmp;
				}

			}
		}
		printNumbers(data);
		return 1;
	}

	public static void quickSort(int[] array, int low, int high) {
		if (array == null || array.length == 0)
			return;
		if (low >= high)
			return;
 
		//pick the pivot
		int middle = low + (high - low) / 2;
		int pivot = array[middle];

		int i = low, j = high;
		while (i <= j) {
			while (array[i] < pivot) {
				i++;
			}
 
			while (array[j] > pivot) {
				j--;
			}
 
			if (i <= j) {
				System.out.print(array[i] + " " + array[j] + "\n");
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
				j--;
			}
		}
		//recursively sort two sub parts
		if (low < j)
			quickSort(array, low, j);
 
		if (high > i)
			quickSort(array, i, high);
	}

	public static void printArray(int[] x) {
		for (int a : x)
			System.out.print(a + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		int[] input = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
		bubble_sort(input);

		int[] input1 = { 4, 7, 3 };
		int[] input2 = { 5, 2, 1 };
		bubble(input1, input2);
		
		//quick sort
		int[] input3 = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
		printArray(input3);
		int low = 0;
		int high = input3.length - 1;
		quickSort(input3, low, high);
		printArray(input3);
	
	}
}
