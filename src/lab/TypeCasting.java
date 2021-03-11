package lab;

public class TypeCasting {
	public static void main(String[] args) {
		byte b = 10;
		short s = 20;
		int i = 100;
		char a = 'a';
		String str = "Sample String";
		float f = 1.7f;
		double d = 278.0;
		
		System.out.println("Implicit Declarartion");
		short byteToShort = s;
		int shortToInt = byteToShort;
		long intToLong = shortToInt;
		float longToFloat = intToLong;
		 
		System.out.println("Short value is " + s);
		System.out.println("byte to short " + byteToShort);
		System.out.println("short to int " + shortToInt);
		System.out.println("Int To Long value " + intToLong);
		System.out.println("Int To Float value " + longToFloat);
		
		System.out.println("\nExplicit Declarartion");
		long doubleToLong = (long) d;
		int longToInt = (int) doubleToLong;
		long intToShort = (short) longToInt;
		float shortToByte = (byte) intToShort;
		 
		System.out.println("Double value is " + d);
		System.out.println("Double To Long " + doubleToLong);
		System.out.println("Long To Int " + longToInt);
		System.out.println("Int To Short value " + intToShort);
		System.out.println("Short To Byte value " + shortToByte);
		
		System.out.println("\nChar to int and vice versa");
		char ch = 'a';
		int num = 121;
		char chara = (char)num;
		System.out.println("Char to Int " + chara);
		System.out.println("Int to Char " + ((int)ch));
	}
}
