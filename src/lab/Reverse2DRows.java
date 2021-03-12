package lab;

import java.util.Scanner;

public class Reverse2DRows {
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
		
		reverseArray(arr, row, col);
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println("");
		}
		s.close();
	}
	
	static void reverseArray(int[][] arr, int row, int col) {
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col / 2; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[i][col - j - 1];
				arr[i][col - j - 1] = temp;
			}
		}
	}
}