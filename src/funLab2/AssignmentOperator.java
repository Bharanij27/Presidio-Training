package funLab2;

public class AssignmentOperator {
	public static void main(String[] args) {
		
		int a = 10, b = 20, c = 5, d = 10;
		
		a += b;
		b -= a;		
		c *= d;
		d /= c;
		
		System.out.println("a = " + a + " b = " + b + " c = " + c + " d = " + d);
	}
}
