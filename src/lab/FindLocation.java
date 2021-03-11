package lab;

import java.util.Scanner;

public class FindLocation {
	static String locationOf(int arr[], int searchingNum) {
		for(int  i = 0; i < arr.length; i++) {
			 if(arr[i] == searchingNum) {
				 return "Searched element is found in " + (i + 1);
			 }
		}
		return "Searched element not found in array";
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int arr[] = GetArray.GetArrayValue();
		System.out.println("Enter Element you want to locate : ");
		int element = scan.nextInt();
		String result = locationOf(arr, element);
		System.out.println(result);
	}
}
