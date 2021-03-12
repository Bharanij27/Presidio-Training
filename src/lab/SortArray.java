package lab;

import java.util.Iterator;
import java.util.Scanner;

public class SortArray {
	static void sort(int[] arr, int sortType) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				if (
						(arr[i] > arr[j] && sortType == 1) ||
						(arr[i] < arr[j] && sortType == 2)
					) { 
					int temp = arr [i]; 
					arr [i] = arr [j]; 
					arr [j] = temp; 
				}
			}
		}
	}
	
	static void printArray(int[] arr) {
		for(int i : arr) {
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int arr[] = GetArray.GetArrayValue();
		int sortType;
		do {
			System.out.println("Enter 1 for ascending order sort \nEnter 2 for descending order sort");
			sortType = scan.nextInt();
		} while(sortType != 1 && sortType != 2);
		sort(arr, sortType);
		printArray(arr);
		scan.close();
	}
}
