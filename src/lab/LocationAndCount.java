package lab;

import java.util.Scanner;

public class LocationAndCount {
	static String findElement(int arr[], int num) {
		int count = 0;
		int index = -1;
		for(int  i = 0; i < arr.length; i++) {
			 if(arr[i] == num) {
				 count++;
				 if(index == -1) index = i;
			 }
		}
		if(count > 0) return "Element Fount at index " + (index + 1) + " and occured " + count + " times";
		return "Element not found";
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int arr[] = GetArray.GetArrayValue();
		System.out.println("Enter Element you want to locate : ");
		int element = scan.nextInt();
		String result = findElement(arr, element);
		System.out.println(result);
	}
}
