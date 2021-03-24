package CollectionTest;
import java.util.*;

public class Q9 {
	public static void main(String[] args) {
       Object o = new Object();
       //HashSet s = new HashSet(); ->works
       LinkedHashSet s = new LinkedHashSet();        
       s.add("o");

       s.add(o);
    }
}