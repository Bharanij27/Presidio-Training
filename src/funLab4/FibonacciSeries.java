package funLab4;

import java.util.Scanner;

public class FibonacciSeries {
	public static void printFibonacci(int n) {
		int firstNum = 0, secondNum = 1;
		if(n == 0);
		else if(n > 1) {
			while(n > 0) {
				System.out.print(firstNum + " ");
				int temp = firstNum;
				firstNum = secondNum;
				secondNum += temp;
				n--;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number ");
		int n = scan.nextInt();
		printFibonacci(n);
		scan.close();
	}
}
