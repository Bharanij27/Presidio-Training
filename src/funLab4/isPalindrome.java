package funLab4;

import java.util.Scanner;

public class isPalindrome {
	public static boolean checkPalindrome(char[] str) {
		int i = 0;
		while(i < str.length) {
			if(!Character.isDigit(str[i]) && !Character.isDigit(str[str.length - i -1])) {
				str[i] = Character.toLowerCase(str[i]);
				str[str.length - i -1] = Character.toLowerCase(str[str.length - i -1]);
			}
			if(str[i] !=  str[str.length - i -1]) return false;
			i++;
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter String / number to check it is palindrome or not");
		String str = scan.next();
		if(checkPalindrome(str.toCharArray())) {			
			System.out.println("Palindrome");
		}
		else System.out.println("Not Palindrome");
		scan.close();
	}
}
