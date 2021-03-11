package lab;

import java.util.Scanner;

public class LargeElement2D {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter number of rows");
		int row = s.nextInt();
		System.out.println("Enter number of cols");
		int col = s.nextInt();
		int arr[][] = new int[row][col];
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				arr[i][j] = s.nextInt();
			}
		}
		findLargest(arr);
	}
	
	static void findLargest(int[][] arr){
		int large = arr[0][0];
		
		for(int a[]: arr) {
			for(int j : a) {
				if(j > large) large = j;
			}
		}
		System.out.println("Largest Number is " + large);
	}
}
