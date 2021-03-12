package funLab2;

import java.util.Scanner;

public class ArearAndPerimeter {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter size of square :");
		int size = scan.nextInt();
		System.out.println("Area of Square is " + (size * size) + " and Perimeter is " + (4  *size));
		
		System.out.println("Enter length of rectangle :");
		int length = scan.nextInt();
		System.out.println("Enter width of rectangle :");
		int width = scan.nextInt();
		System.out.println("Area of Square is " + (length * width) + " and Perimeter is " + ((2  * length) + (2 * width)));
		scan.close();
	}
}
