package funLab4;

import java.util.Scanner;

public class EvenNumbers {
	public static void findEvenNumbers(int n) {
		int i = 0;
		while(i <= n) {
			if(i % 2 == 0) System.out.println(i);
			i++;
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number to find even numbers from (0 - n): ");
		int n = scan.nextInt();
		findEvenNumbers(n);
		scan.close();
	}
}
