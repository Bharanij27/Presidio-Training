package lab;

public class AccessCommandLine {
	public static void main(String[] args) {
		if(args.length > 0) {
			for(String i : args) {
				System.out.println(i);
			}
		}
		else {
			System.out.println("No argument is passed from command line");
		}
	}
}
