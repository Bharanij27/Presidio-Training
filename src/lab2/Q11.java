package lab2;

/*
 * Modify above Exercise  so that A and B have constructors 
 * with arguments instead of default constructors.
 * Write a constructor for C and perform all initialization 
 * within C’s constructor.
 * */

//A
class Base{
	int a;
	Base(int num){
		a = num;
		System.out.println("A initialized with " + a);
	}
}


//B
class Sibling{
	int b;
	Sibling(int num){
		b = num;
		System.out.println("B initialized with " + b);
	}
}

// class C
public class Q11 extends Base{
	
	Q11(int num){
		super(num);
		Sibling obj = new Sibling(num);
	}
	
	public static void main(String[] args) {
		Q11 newObj = new Q11(10);
	}
}

