package day9;

import java.lang.reflect.Field;

public class ExceptionDemo {
	public static void main(String[] args) throws Exception{
		String s = "str";
		String name = "name";
		boolean hasMethod = false;
		Field f[] = s.getClass().getFields();
		for(Field field : f) {
			if(field.getName().equals(name)) {
				hasMethod =  true;
			}
		}
		if(hasMethod) {
			System.out.println("Has method");
			Field field = s.getClass().getField(name);
		}
		System.out.println("No such exception");
	}
}
