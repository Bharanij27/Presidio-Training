package fileLab;

import java.io.File;

public class RenameAndDelete {
	static void p(String s) {
		System.out.println(s);  
	}
	
	public static void main(String args[]){
		File f1=new File("ex.txt");
		System.out.println(f1.renameTo(new File ("exa.txt")));
		System.out.println(f1.delete());
	}
}
