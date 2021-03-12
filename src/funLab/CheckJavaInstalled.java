package funLab;

public class CheckJavaInstalled {
	public static void main(String[] args) {
		System.out.println("java version : " + System.getProperty("java.version"));
		System.out.println("java runtime version : " + System.getProperty("java.runtime.version"));
		System.out.println("java home : " + System.getProperty("java.home"));
		System.out.println("java vendor : " + System.getProperty("java.vendor"));
		System.out.println("java vendor url : " + System.getProperty("java.vendor.url"));
		System.out.println("java class path : " + System.getProperty("java.class.path"));
	}
}
