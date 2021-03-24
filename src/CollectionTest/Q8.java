package CollectionTest;

import java.util.ArrayList;
import java.util.List;

public class Q8 {
	public static void main(String[] args) {
		
	}
	
	public static <E extends Number> List<E> process(List<E> nums){
		List<Integer> input = null; 
		List<Integer> output = null;
		output = process(input);
		return  (List<E>) output;
	}
}
