package lab;

import java.util.Scanner;

public class StairCaseArray {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter array size : ");
		int size = scan.nextInt();
		int arr[][] = new  int[size][];
		
		int value = 1;
		for(int i = 0; i < arr.length; i++) {
			arr[i] = new int[i + 1];
			for(int j = 0; j <= i; j++) {
				arr[i][j] = value++;
			}
		}
		
		for(int rows[] : arr) {
			for(int ele : rows) {
				System.out.print(ele +" ");
			}
			System.out.println();
		}
	}
}
