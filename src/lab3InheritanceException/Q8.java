package lab3InheritanceException;

import java.util.Scanner;

public class Q8 {
	public static void main(String[] args) {
		int studentMarks[] = new int[10];
		int i = 0;
		Scanner scan = new Scanner(System.in);
		while(i < 10) {			
			try {
				System.out.println("Enter Student " + (i + 1) + " mark");
				String mark = scan.next();
				int num = Integer.parseInt(mark);
				if(num < 0) throw new NegativeMark();
				if(num > 100) throw new NonValidMark();
				studentMarks[i] = num;
				i++;
			} catch (NumberFormatException e) {
				System.out.println("Please enter a number");
			}
			catch (NonValidMark e) {
				System.out.println(e);
			}
			catch (NegativeMark e) {
				System.out.println(e);
			}
		}
		
		for(int j = 0; j < studentMarks.length; j++) {
			System.out.println("Student " + (j + 1) + " mark : "  + studentMarks[j]);
		}
	}
}

abstract class MarkException extends Exception{
}

class NegativeMark extends MarkException{	
	@Override
	public String toString() {
		return "Enter non negative Integer";
	}
}

class NonValidMark extends MarkException{
	@Override
	public String toString() {
		return "Enter valid mark";
	}
}

/*
 * class Student{
 * 
 * }
 */