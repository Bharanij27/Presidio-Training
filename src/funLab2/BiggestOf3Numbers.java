package funLab2;

public class BiggestOf3Numbers {
	public static int getMax(int a, int b) {
	    int c = a - b;
	    int k = (c >> 31) & 1;
	    int max = a - k * c;
	    return max;
	}
	
	public static void main(String[] args) {
		int a = 10, b = 20, c = -30;
		int maxOf2 = getMax(a, b);
		int maxOf3 = getMax(maxOf2, c);
		System.out.println("Max of 3 number is " + maxOf3);
	}
}
