package lab;

import java.util.Scanner;

public class Q21 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int month = s.nextInt();
		int num = 0;
		if (month == 2)  num =2;
		else if(
				(month <= 7 && month % 2 != 0) || 
				(month >= 8 && month % 2 == 0) 
			) num = 1;

		switch (num) {
		case 2:
			System.out.println("Enter year");
			int year = s.nextInt();
			if(year % 4 == 0) System.out.println("Leap Year");
			else System.out.println("Non Leap Year");
			break;
		case 1: 
			System.out.println("31 days"); 
			break;
		default:
			System.out.println("30 days"); 
			break;
		}
	}
}
