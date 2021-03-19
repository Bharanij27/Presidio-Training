package lab3InheritanceException;

public class Q5 {
	public static void main(String[] args) throws NewException {
		throw new NewException("Thrown from different classs");
	}
}
