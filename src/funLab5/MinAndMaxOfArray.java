package funLab5;

import lab.GetArray;

public class MinAndMaxOfArray {
	public static void main(String[] args) {
		int arr[] = GetArray.GetArrayValue();
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for(int  i = arr.length - 1; i >= 0; i--) {
			if(min > arr[i]) min = arr[i];
			if(max < arr[i]) max = arr[i];
		}
		System.out.println("Biggest Element is " + max + " Lowest Element is " + min);
	}
}
