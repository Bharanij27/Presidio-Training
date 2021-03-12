package funLab5;
import java.util.Scanner;

public class SwapTwoArray {
	
	public static void printArray(int[] arr) {
		System.out.println();
		for(int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public static void swapArray(int[] arr1, int[] arr2) {
		for(int i = 0; i < arr1.length; i++) {
			arr1[i] = arr1[i] + arr2[i];
			arr2[i] = arr1[i] - arr2[i];
			arr1[i] = arr1[i] - arr2[i];
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter size of array 1 and 2 ");
		int size = scan.nextInt();
		int arr1[] = new int[size];
		int arr2[] = new int[size];
		
		System.out.println("Enter array 1 elements");
		for(int i = 0; i < size; i++) {
			arr1[i] = scan.nextInt();
		}
		
		
		System.out.println("Enter array 2 elements");
		for(int i = 0; i < size; i++) {
			arr2[i] = scan.nextInt();
		}
		
		System.out.println("Array before swap ");
		printArray(arr1);
		printArray(arr2);
		
		swapArray(arr1, arr2);
		
		System.out.println("Array after swap ");
		printArray(arr1);
		printArray(arr2);
	}
}
