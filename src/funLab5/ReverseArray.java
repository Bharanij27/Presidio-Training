package funLab5;

import lab.GetArray;

public class ReverseArray {
	public static void main(String[] args) {
		int arr[] = GetArray.GetArrayValue();
		for(int  i = arr.length - 1; i >= 0; i--) {
			System.out.println(arr[i]);
		}
	}
}
