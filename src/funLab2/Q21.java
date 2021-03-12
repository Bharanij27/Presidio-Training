package funLab2;

public class Q21 {
	public static void main(String[] args) {
		 boolean a = true, b = false;
		 boolean c = a | b; 
		 boolean d = a & b; 
		 boolean e = a ^ b; 
		 boolean f = (! a & b) | (a &! b); 
		 boolean g =! a;
		 
		 System.out.println("c : " + c);
		 System.out.println("d : " + d);
		 System.out.println("e : " + e);
		 System.out.println("f : " + f);
		 System.out.println("g : " + g);
	}
}
