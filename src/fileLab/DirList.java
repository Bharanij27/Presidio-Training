package fileLab;
import java.io.File;

public class DirList {
	public static void main(String args[]){
		String dirname="/usr";
		File f1=new File(dirname);
		if(f1.isDirectory()){
			System.out.println("On directory");
			String s[]=f1.list();
			for(int I=0;I<s.length;I++)
			{ 
				System.out.println(s[I]); }  
			} 
	}
}
