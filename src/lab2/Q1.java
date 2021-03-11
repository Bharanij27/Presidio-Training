package lab2;

public class Q1 {
	public static void passValues(int i, double d, char a, int[] arr) {
		i++;
		d = 100.01;
		a = 'b';
		for(int j = 0; j < arr.length; j++) arr[j]++;
	}
	
	public static void printValue(int i, double d, char a, int[] arr) {
		System.out.println("int  = " +i);
		System.out.println("double  = " +d);
		System.out.println("char  = " + a);
		System.out.println("Array value");
		for(int j = 0; j < arr.length; j++) System.out.println(arr[j]);
	}
	
	
	public static void main(String[] args) {
		int i = 10;
		double d = 20.1;
		char a = 'a';
		int arr[] = {1, 2, 3};
		
		System.out.println("Before pass");
		printValue(i, d, a, arr);
		passValues(i, d, a, arr);
		System.out.println("After pass");
		printValue(i, d, a, arr);
	}
}
