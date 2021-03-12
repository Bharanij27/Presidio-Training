package funLab;

import java.util.Scanner;

public class CountInString {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a String : ");
		String str = scan.nextLine();
		count(str);
		scan.close();
	}
	
	public static void count(String str) {
		char[] chArray = str.toCharArray();
		int letter = 0, space = 0, num = 0, otherChar = 0;
		
		for(char i : chArray) {
			if(Character.isLetter(i)) letter++;
			else if(Character.isDigit(i)) num++;			
			else if(Character.isSpaceChar(i)) space++;
			else otherChar++;
		}
		System.out.println("The String \"" + str + "\" conatins");
		System.out.println("Letter : " + letter);
		System.out.println("Digit : " + num);
		System.out.println("Space : " + space);
		System.out.println("Others Characters : " + otherChar);
	}
}
