package com.abc.example;

public class Search {
	//linear
	public static int[] linear_search(int[] array, int key){
		int size = array.length;
		int savedItems [] = new int[size];
		
		for (int i=0; i<=size-1; i++){
			savedItems[i]=-1;
			if (key == array[i]){
				System.out.printf("found the item at %d\n", i);
				savedItems[i] = i;
			}
		}
		return savedItems;
	}
	
	//binary search on sorted array
	public static boolean binarySearch(int [] data,int key) {
		int low = 0;
		int high = data.length - 1;
  
		while(low <= high) {
			int middle = (low + high) / 2;
			
			if(data[middle] == key) {
				return true;
			}
			if(data[middle] < key) {
				low = middle + 1;
			}
			if(data[middle] > key) {
				high = middle - 1;
			}
			}
			return false;
		}
	
	public static void main(String args[]){
		//linear serch
		int [] elements = {12, 23, 75, 12, 7, 2, 12, 10, 12};
		int key = 12;
		
		int [] foundItems = linear_search(elements, key);
		
		for (int i=0; i<=foundItems.length-1; i++){
			if (foundItems[i]!=-1)
				System.out.printf("found the item at index of %d\n", foundItems[i]);
		}
		
		//binary search
		int [] elements2 = {12, 45, 76, 89, 102, 899};
		boolean found = binarySearch(elements2, key);
		System.out.print("found the searched item: " + found + "\n");
		
		//print multiple arrays
		int [][] data = {{12, 23, 75, 12, 7, 2, 12, 10, 12}, {1, 2, 3}};
		
		for(int k=0; k<data.length; k++){
			for(int j=0; j<data[k].length; j++){
				System.out.print(data[k][j] + ", ");
			}
			System.out.print("\n");
		}
	}
}
