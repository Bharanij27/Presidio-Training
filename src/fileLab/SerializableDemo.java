package fileLab;

import java.io.* ;

class emp implements Serializable
{
	public int eno ;
	public String ename ;
	emp(int a, String m)
	{	
		eno=a ;
		ename=m; 
	}
	void print()
	{
		System.out.println(eno + " \t:\t " + ename ) ;
	}
}

public class SerializableDemo{
	public static void main(String arg[]) throws Exception	
	{
		FileOutputStream fos = new FileOutputStream ("emp.dat") ;
		// we can direct read using ObjectOutputStream we can serialize and deserialize
		ObjectOutputStream oos = new ObjectOutputStream(fos) ;
		emp ob ;
		for ( int i=0; i<10;i++)
		{
			ob =  new emp(i,"name"+i) ;
			oos.writeObject(ob) ;
		}
		
		FileInputStream fis = new FileInputStream("emp.dat") ;
		ObjectInputStream ois = new ObjectInputStream(fis) ;
		emp readob ;
		while((readob = (emp) ois.readObject())!=null) {
			readob.print() ;	
		}
	}	
}
