package lab;

import java.util.Scanner;

public class PrimeNumbers {
	static boolean isPrime(int num) {
		for(int  i = 2; i <= num / 2; i++) {
			if(num % i == 0) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		int a;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter positive number to check it is prime or not : ");
		a = scan.nextInt();
		String result = isPrime(a) == true ? "Prime Number" : "Non Prime Number" ;
		System.out.println(result);
		scan.close();
	}
}
