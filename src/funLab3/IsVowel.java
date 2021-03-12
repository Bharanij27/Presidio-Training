package funLab3;

import java.util.Scanner;

public class IsVowel {
	public static void main(String[ ] arg)
	   {
		boolean isVowel = false;;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a character : ");
		char ch = scanner.next().toLowerCase().charAt(0); 
		switch(ch)
		{
		   case 'a' :
		   case 'e' :
		   case 'i' :
		   case 'o' :
		   case 'u' : isVowel = true;
		}
		if(isVowel == true) {
		   System.out.println(ch + " is  a Vowel");
		}
		else {
		   System.out.println(ch + " is not a vowel");
	   }
	   scanner.close();
	}
}
