package day14;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleDemo {
	public static void main(String[] args) {
		Locale locale = Locale.getDefault();
		
		System.out.println("Default locale is  " + locale);
		
		Locale.setDefault(new Locale("ta"));
		
		System.out.println("Now Default locale is  " + locale);
		
		locale = Locale.getDefault();
		
		ResourceBundle rb = ResourceBundle.getBundle("dictionary", locale);

		System.out.println(rb.getString("hello"));
		
		Locale.setDefault(new Locale("jp"));
		locale = Locale.getDefault();
		
		rb = ResourceBundle.getBundle("dictionary", locale);

		System.out.println(rb.getString("thanks"));
		
		
		/*
		 * Example 2 
		 * Because sometimes file not found may happen so create a java resource file
		 * */
		
		Locale.setDefault(new Locale("ta"));
		locale = Locale.getDefault();
		
		rb = ResourceBundle.getBundle("day14.Dictionary", locale);

		System.out.println(rb.getString("name"));
		
	}
}
