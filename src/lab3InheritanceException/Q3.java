package lab3InheritanceException;

import java.io.IOException;

public class Q3 {
	public void mth1() {
		System.out.println("Before meth2 call");
		mth2(); 
		System.out.println("caller");
	}
	public void mth2() {
		try {
			// line 1 return;
			System.exit(0);
		}
		catch(Exception e){ 
			System.out.println("catch-mth2");
		}
		finally{
			System.out.println("finally-mth2");
		}
	}
	public static void main(String p[])
	{
		Q3 s=new Q3();
		s.mth1();
	}
}