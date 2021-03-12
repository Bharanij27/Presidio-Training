package funLab;
import java.io.Console;


public class DisplayPassword {
	public static void main(String[] args) {
		Console cons;
		if((cons = System.console()) != null) {
			char[] password = null;
			try {
				password = cons.readPassword("Enter your password");
				System.out.println("Your Passsword is : " + String.valueOf(password));
			} finally {
				if(password != null) {
					java.util.Arrays.fill(password, ' ');
				}
			}
		}
		else {
			throw new RuntimeException("Can't get password...No Console");
		}
	}
}
