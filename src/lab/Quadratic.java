package lab;
import java.io.*;
import static java.lang.Math.*;

public class Quadratic {
	public static void main(String[] args) {
		int a = 1, b = -7, c = 12;
	    findRoots(a, b, c);
	}
	static void findRoots(int a, int b, int c){
		if (a == 0) {
			System.out.println("Invalid");
			return;
		}
		int d = b * b - 4 * a * c;
	    double sqrt_val = sqrt(abs(d));
	
	    if (d > 0) {
	    	System.out.println("Roots are real and different");
	        double root1 = (-b + sqrt_val) / (2 * a); 
	        double root2 = (-b - sqrt_val) / (2 * a);
	    	System.out.println(root1 + " " + root2);
	     }
	     else if (d == 0) {
	         System.out.println("Roots are real and same \n");
	         System.out.println(-(double)b / (2 * a) + " " + -(double)b / (2 * a));
	     }
	     else
	     {
	         System.out.println("Roots are complex \n");
	         System.out.println(-(double)b / (2 * a) + " + i" + sqrt_val + " and "
	                            + -(double)b / (2 * a) + " - i" + sqrt_val);
	     }
	 }
}