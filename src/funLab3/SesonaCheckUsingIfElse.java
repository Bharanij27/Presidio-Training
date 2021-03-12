package funLab3;

import java.util.Scanner;

public class SesonaCheckUsingIfElse {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter month (1 - 12):");
		int month = scan.nextInt();
		
		if(month == 12 || month == 1 || month == 2) {
			System.out.println("Winter");
		}
		else if(month == 3 || month == 4 || month == 5) {
			System.out.println("Spring");
		}
		else if(month == 6 || month == 7 || month == 8) {
			System.out.println("Summer");
		}
		else {
			System.out.println("Autumn");
		}
		scan.close();
	}
}
