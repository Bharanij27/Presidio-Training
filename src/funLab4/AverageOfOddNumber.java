package funLab4;

import java.util.Scanner;

public class AverageOfOddNumber {
	public static void findOddAverage(int n) {
		int sum = 0, count = 0;
		int i = 0;
		while(i <= n) {
			if(i % 2 != 0) {
				count++;
				sum += i;
			}
			i++;
		}
		System.out.println("Average of odd number in range " + sum / count);
	}
		
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number to find  average of odd number below range (0 - n): ");
		int n = scan.nextInt();
		findOddAverage(n);
		scan.close();
	}
}
