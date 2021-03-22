package day6;
public class ObjectCreationDemo {
	
	public static void main(String[] args) throws Exception {
		MyBusinessLogic myb = MyBusinessLogic.createObject();
		myb.str="first object...";
		
		myb.setMyl(DataLogic.createObject());
		
		MyBusinessLogic myb2=MyBusinessLogic.createObject();
		myb2.str="second object...";
		
		System.out.println(myb.str);
	}
}


class MyBusinessLogic implements Cloneable{
	String str;
	private static MyBusinessLogic myb;
	DataLogic myDataLogic;
	
	
	public DataLogic getMyl() {
		return myDataLogic;
	}

	public void setMyl(DataLogic myl) {
		myDataLogic = myl;
	}

	private MyBusinessLogic() {
		System.out.println("cons called...");		
	}
	
	synchronized public static MyBusinessLogic createObject() throws Exception{
		if(myb==null) {
			myb=new MyBusinessLogic();
		}
		return myb.createClone();		
	}

	public  MyBusinessLogic createClone() throws Exception{	
			return (MyBusinessLogic) super.clone();		
	}
}

class DataLogic implements Cloneable{
	private static DataLogic myl;

	private DataLogic() {
		System.out.println("Data Logic cons....");
	}

	synchronized public static DataLogic createObject() throws Exception{
		if(myl==null) {
			myl=new DataLogic();
		}
		return myl.createClone();		
	}

	public DataLogic createClone() throws Exception{	
			return (DataLogic) super.clone();		
	}
}

//My Resources are shared but still properties are unique...