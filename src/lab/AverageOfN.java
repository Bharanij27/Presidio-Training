package lab;
import lab.GetArray;

public class AverageOfN {
	static double averageOf(int[] arr) {
		int sum = 0;
		for(int i : arr) {
			sum += i;
		}
		return sum / arr.length;
	}
	
	public static void main(String[] args) {
		
		int numbers[] = GetArray.GetArrayValue();
		System.out.print("The average of ");
		for(int i : numbers) {
			System.out.print(i + " ");
		}
		System.out.println("is " + averageOf(numbers));
	}
}
