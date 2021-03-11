package lab;

import java.util.Scanner;

public class GetArray {
	public static int[] GetArrayValue() {
		// TODO Auto-generated constructor stub
		Scanner scan = new Scanner(System.in);
		System.out.println("How many number you want to enter : ");
		int arraySize = scan.nextInt();
		int numbers[] =  new int[arraySize];
		System.out.println("Enter "+ arraySize + " integers");
		for (int i = 0; i < arraySize; i++) {
			numbers[i] = scan.nextInt();
		}
		return numbers;
	}
}
