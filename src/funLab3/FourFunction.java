package funLab3;

import java.util.Scanner;

public class FourFunction {
	
	public static void add(int a, int b) {
		System.out.println(a + b);
	}
	
	public static void sub(int a, int b) {
		System.out.println(a - b);
	}
	
	public static void multiply(int a, int b) {
		System.out.println(a * b);
	}
	
	public static void divide(int a, int b) {
		System.out.println(a / b);
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter fisrt number");
		int a = scan.nextInt();
		System.out.println("Enter Second number");		
		int b = scan.nextInt();
		System.out.println("1. Add \n2. Sub \n3. Multiply \n4. Divide");
		System.out.println("Enter your choice");
		
		int opt;
		do {			
			opt = scan.nextInt();
			switch (opt) {
			case 1:
				add(a, b);
				break;
			case 2:
				sub(a, b);
				break;
			case 3:
				multiply(a, b);
				break;
			case 4:
				divide(a, b);
				break;
			default:
				System.out.println("Enter valid option");
				break;
			}
		} while (opt > 4 || opt < 1);
		scan.close();
	}
}
