package fileLab;

import java.io.File;

public class Q1 {
	static void p(String s) {
		System.out.println(s);  
	}
	public static void main(String args[]){
		File f1=new File("abc.properties");
		p("file name :"+f1.getName());
		p("path :"+f1.getPath());
		p(f1.exists() ? "exists":"does not exist");
		p(f1.canWrite() ? "is writable":"is not writable");
		p(f1.isDirectory() ?" is a dir":"is not a directory");
	}
}
