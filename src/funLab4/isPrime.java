package funLab4;

import java.util.Scanner;

public class isPrime {
	
	public static boolean isPrimeNumber(int n) {
		int i = 2;
		while(i <= n / 2) {
			if(n % i == 0) return false;
			i++;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number to check");
		int n = scan.nextInt();
		if(isPrimeNumber(n)) {
			System.out.println(n + " is a Prime Number");
		}
		else System.out.println(n + " is not a Prime Number");
		scan.close();
	}
}
