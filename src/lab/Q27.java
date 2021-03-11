package lab;

public class Q27 {
	public static void main(String[] args) {
		int investment = 14000;
		
		//during first year 
		investment += (investment * 0.4);
		// during second year
		investment -= 1500;
		//during third year
		investment += (investment * 0.12);
		System.out.println("Investment worths $" + investment );
	}
}
