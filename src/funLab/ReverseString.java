package funLab;

import java.util.Scanner;

public class ReverseString {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a String : ");
		char[] letter = scan.nextLine().toCharArray();
		System.out.println("Reversed String");
		for(int i = 0; i < letter.length / 2; i++) {
			char temp = letter[i];
			letter[i] = letter[letter.length - 1 - i];
			letter[letter.length - 1 - i] = temp;
		}
		System.out.println(String.valueOf(letter));
		scan.close();
	}
}
