package lab3InheritanceException;

public class CustomException {
	public static void main(String[] args) {
		try {
			throw new NewException("Demo Exception Thrown ");
		} catch (NewException e) {
			System.out.println(e);
		}
	}
}


class NewException extends Exception{
	
	public String mesg;
	
	public NewException(String str) {
		this.mesg = str;
	}
	
	@Override
	public String toString() {
		return this.mesg.toString();
	}
}