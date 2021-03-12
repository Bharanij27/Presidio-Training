package lab;

import java.util.Scanner;

public class NumberToWord {
	static String convertToWord(int num) {
		String word = "";
		while(num > 0) {
			int temp = num % 10;
			word = getWord(temp) + word;
			num /= 10;
		}
		return word;
	}
	
	static String getWord(int num) {
		switch (num) {
		case 1:
			return "one ";
		case 2:
			return "two ";
		case 3:
			return "three ";
		case 4:
			return "four ";
		case 5:
			return "five ";
		case 6:
			return "six ";
		case 7:
			return "seven ";
		case 8:
			return "eight ";
		case 9:
			return "nine ";
		default:
			return "zero ";
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		if(num == 0) System.out.print("Zero");
		else System.out.println(convertToWord(num));
		scan.close();
	}
}
