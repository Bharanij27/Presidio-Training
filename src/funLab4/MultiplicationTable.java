package funLab4;

import java.util.Scanner;

public class MultiplicationTable {
	
	public static void printTable(int n) {
		int i = 1;
		do {
			System.out.println(n + " * " + i + " = " + n * i);
			i++;
		}while(i <= 10);
	}
	
	public static void main(String[] args) {		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number ");
		int n = scan.nextInt();
		printTable(n);
		scan.close();
	}
}
