package funLab;

public class UniqueThreeDigits {
	public static void main(String[] args) {
		int count = 0;
		for (int i = 1; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 4; k++) {
					if(i != j && i != k && j != k) {
						count++;
						System.out.println(i+""+j+""+k);
					}
				}
			}
		}
		System.out.println("Total Unique Three Digit Numbers are : " + count);
	}
}
