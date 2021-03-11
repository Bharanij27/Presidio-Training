package lab.JavaDocs;

/**
 * Documentation Comment - 
 * A simple java program with some necessary information
 * Author : Bharani
 * Version 0.1
 * CreatedAt 11-03-2021 
 **/

// Single line Comment

/*This is 
 * an 
 * Multi line comment
 */

public class Documentataion {
	
	public static void main(String[] args) {
		System.out.println("Can't write main without public keyword. If it's not public it wont be visisble"
				+ " beyond its class and package. So JVM can't able find it");
		System.out.println("Can't write main without static keyword. it should be available without creating instances");
		System.out.println("parameter args should be available");
	}
}	
