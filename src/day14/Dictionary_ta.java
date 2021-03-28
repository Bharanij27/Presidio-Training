package day14;

import java.util.ListResourceBundle;

public class Dictionary_ta extends ListResourceBundle{
	Object obj[][] = {
			{"hello", "vanakam"},
			{"name", "peyar"}
	};
	
	@Override
	protected Object[][] getContents() {
		return obj;
	}
	
}
