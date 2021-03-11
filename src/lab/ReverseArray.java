package lab;

public class ReverseArray {
	
	static void printArray(int arr[]){
		for(int i : arr) {
			System.out.print(i + " ");
		}
	}
	
	static void reverse(int arr[]) {
		for(int  i = 0; i < arr.length / 2; i++) {
			int temp = arr[i];
			arr[i] = arr[arr.length - i -1];
			arr[arr.length - i -1] = temp;
		}
	}
	
	public static void main(String[] args) {
		int arr[] = GetArray.GetArrayValue();
		printArray(arr);
		reverse(arr);
		System.out.println("\nAfter reverse : ");
		printArray(arr);
	}
}
