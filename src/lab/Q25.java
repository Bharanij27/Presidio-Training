package lab;

public class Q25 {

}

// making class as protected will make it visible only to class in relationship with it
// outside world can't access protected class

/*protected */ class base { 
	String Method() { 
		return "Wow"; 
		} 
}

class dervied { 
	public void useD() { 
		base z = new base();
		System.out.println("base says, " + z.Method());
		}
} 
