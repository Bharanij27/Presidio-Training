package lab;
import java.util.Scanner;

import lab.PrimeNumbers;

public class CategorizeNumber {
	
	static void primeFrom1To100() {
		System.out.println("Prime Numbers from 1 to 100");
		for(int i = 2; i <= 100; i++) {
			if(PrimeNumbers.isPrime(i) == true) {
				System.out.print(i + " ");
			}
		}
	}

	static void isArmstrongAndPalindrome(int num) {
		int armstrong = 0;
		int palindrome = 0;
		int initialValue = num;
		while(num > 0) {
			int lastDigit = num % 10;
			armstrong += (lastDigit * lastDigit * lastDigit);
			palindrome = (palindrome * 10) + lastDigit;
			num /= 10;
		}
		printValue(initialValue, armstrong, "Armstrong");
		printValue(initialValue, palindrome, "Palindrome");
	}
	
	static void isPerfect(int num) {
		int sum = 0;
		for(int i = 1; i < num; i++) {
			if(num % i == 0) sum += i;
		}
		printValue(num, sum, "Perfect");
	}
	
	static void printValue(int original, int calculated, String type) {
		if(calculated == original) {			
			System.out.println(original +  " is an" + type + " Number");
		}
		else {
			System.out.println(original +  " is not an " + type + " Number");
		}
	}
	
	public static void main(String[] args) {
		primeFrom1To100();
		System.out.println("\nEnter a number to check it is Armstrong number or perfect number or  palindrome or none of these");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		isArmstrongAndPalindrome(num);
		isPerfect(num);
	}
}
