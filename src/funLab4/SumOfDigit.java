package funLab4;

import java.util.Scanner;

public class SumOfDigit {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter String / number to check it is palindrome or not");
		int num = scan.nextInt();
		int numCopy = num;
		int sum = 0;
		
		while(num > 0) {
			int digit = num % 10;
			sum += digit;
			num = num / 10;
		}
		System.out.println("Sum of digits of a number " + numCopy + " is " + sum);
		scan.close();
	}
}
