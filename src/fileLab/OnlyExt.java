package fileLab;
import java.io.*;

class DemoClass implements FilenameFilter{
	String ext;
	public DemoClass(String e){ 	
		ext="."+e;  
	}
	
	public boolean accept(File dir, String name){
		return name.endsWith(ext);
 }    

}

public class OnlyExt{
	public static void main(String args[]){
		String dirname="/users";
		File f1=new File(dirname);
		FilenameFilter only=new DemoClass("html");
		String s[]=f1.list(only);
		for (int i=0;i<s.length;i++){
			System.out.println(s[i]);   
		}    
	}   
}