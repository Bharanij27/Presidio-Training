package funLab3;

import java.util.Scanner;

public class SesonaCheckUsingSwitch {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter month (1 - 12):");
		int month = scan.nextInt();
		
		switch(month)
		{
		   case 12:
		   case 1:
		   case 2: 
			   System.out.println("Winter"); 
			   break;
		   case 3:
		   case 4:
		   case 5: 
			   System.out.println("Spring"); 
			   break;
		   case 6 :
		   case 7:
		   case 8:
			   System.out.println("Summer"); 
			   break;
		   default:
			   System.out.println("Autumn"); 
			   break;
		}
		scan.close();
	}
}
