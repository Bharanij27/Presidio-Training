package funLab3;

public class ControlStatments_Q27 {
	
	public static void selectionStatements() {
		int a = 10;
		
		System.out.println("If statement...");
		if(a >= 10) System.out.println("Inside If condition\n");

		System.out.println("If else statement...");
		if(a > 10) System.out.println("a > 10 Inside If else condition\n");
		else System.out.println("a < 10 Inside if else statment\n");
		
		System.out.println("NestedIf statement...");
		int b = 15;
		if(b > 10) {
			if(b < 20) {				
				System.out.println("b > 10 and b < 20 Inside Nested If condition\n");
			}
		}
		
		int num = 1;
		
		switch (num) {
		case 1:
			System.out.println("Inside Switch Statement : One \n");
			break;
		default:
			System.out.println("Inside Switch Statement : Zero \n");
			break;
		}
		
	}
	
	public static void loopingStatements() {
		System.out.println("While loop (run until condition true) -> prints 1 to 3");
		int i = 1;
		while(i < 4) {
			System.out.println(i++);
		}
		
		System.out.println("\ndo While loop (run atleast once) -> prints 4 to 1");
		do {
			System.out.println(i--);
		}while(i >= 1);
		
		System.out.println("\nForEach loop -> Iterate over array");
		int arr[] = {1, 2, 3, 4, 5};
		
		for (int j : arr) {
			System.out.println(j);
		}
		
		System.out.println("\nFor loop -> reverse print array");
		for (int j = arr.length - 1; j >= 0; j--) {
			System.out.println(arr[j]);
		}
	}
	
	public static void branchingStatements() {
		System.out.println("Braek -> print 1 to 5 and breaks while loop\n");
		int i = 1;
		while (true) {
			if(i > 5) break;
			System.out.println(i++);
		}
		
		System.out.println("Braek -> print even number between  1 to 10 using continue statement\n");
		int n = 1;
		while (n <= 10) {
			if(n % 2 == 0) {
				System.out.println(n);
			}
			n++;
			continue;
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println("Control Statements can be divided into three categories");
		System.out.println("1. Selection statements \n2. Iteration statements \n3. Jump statements");
		
		System.out.println("\nSelection statements / Decision Making Statements\n");
		selectionStatements();
		
		System.out.println("\nLooping statements / Iteration Statements\n");
		loopingStatements();
		
		System.out.println("\nBranching statements / Jump Statements\n");
		branchingStatements();
	}
}
