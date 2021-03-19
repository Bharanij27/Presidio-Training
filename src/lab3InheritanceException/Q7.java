package lab3InheritanceException;

import java.util.Scanner;

public class Q7 {
	public static void main(String[] args) {
		int numerator;
		int denominator;
		while(true) {			
			try {
				System.out.println("Enter Numerator or Enter q or Q to exit ");
				numerator = new GetInput().number.value;

				System.out.println("Enter Denominator");
				denominator = new GetInput().number.value;
				
				System.out.println(numerator + " / " + denominator + " = " + numerator / denominator);
			} catch (ArithmeticException e) {
				System.out.println("Cannot divide by 0 please valid numbers");
			}
		}
	}
}


class GetInput {
	Number number;
	
	public GetInput() {
		boolean cond;
		number = new Numerator();
		do {
			cond = number.getNumber();
		} while (cond);
	}
}

abstract class Number{
	public int value;
	public boolean getNumber() {
		String num = "";
		boolean returnVar = true;
		try {
			Scanner scan = new Scanner(System.in);
			num = scan.next();
			value = Integer.parseInt(num);
			returnVar = false;
		} catch (NumberFormatException e) {
			isValidChar(num.charAt(0));
		}
		return returnVar;
	}
	
	abstract public void isValidChar(char ch);
}


class Numerator extends Number{	
	@Override
	public void isValidChar(char ch) {
		if(Character.toLowerCase(ch) == 'q') System.exit(0);
		System.out.println("enter valid number");
	}
}

class Denominator extends Number{
	
	@Override
	public void isValidChar(char ch) {
		System.out.println("Enter valid Number");
	}
}