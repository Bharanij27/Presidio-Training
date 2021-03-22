package day8;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Scanner;

public class InterfaceDemoDynamic {
	public static void main(String[] args) {
		AlopathyMedicalCollegee stanley=new AlopathyMedicalCollegee();
		AyurvedMedicalCollegee imcops=new AyurvedMedicalCollegee();
		
		JetAcademy jet=new JetAcademy();
		
		Object shoiab=new Human();//1974
	
		shoiab=Proxy.newProxyInstance(shoiab.getClass().getClassLoader(),
								new Class[] {Docterr.class,Pilot.class},
								new MyInvocationHandlerr(new Object[] {shoiab,jet,stanley}));
		
		Docterr DocterrShoiab=(Docterr)shoiab;
		DocterrShoiab.doCure();
		
		Pilot pilot=(Pilot)shoiab;
		pilot.doFly();
		Scanner scan=new Scanner(System.in);
		System.out.println("waiting..............");
		String s=scan.next();
		
		StewardAcademy sa=new StewardAcademy();
		shoiab=Proxy.newProxyInstance(shoiab.getClass().getClassLoader(),
				new Class[] {Docterr.class,Pilot.class,Steward.class},
				new MyInvocationHandlerr(new Object[] {shoiab,sa}));
		
		Steward stewardShoiab=(Steward)shoiab;
		stewardShoiab.serve();
		
		 DocterrShoiab=(Docterr)shoiab;
		DocterrShoiab.doCure();
		
		 pilot=(Pilot)shoiab;
		pilot.doFly();
	}
}
class MyInvocationHandlerr implements InvocationHandler{
	Object obj[];
	public MyInvocationHandlerr(Object obj[]) {
		this.obj=obj;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object returnObject=null;
		for(Object o:obj) {
			Method m[]=o.getClass().getDeclaredMethods();
			for(Method met:m) {
				System.out.println(met.getName());
				if(met.getName().equals(method.getName())) {
					met.setAccessible(true);
					returnObject=method.invoke(o, args);
				}
			}
		}
		return returnObject;
	}
}
interface Steward{
	public void serve();
}
interface Pilot{
	public void doFly();
}
class StewardAcademy implements Steward{
	@Override
	public void serve() {
		System.out.println("serving...................");
	}
}
class JetAcademy implements Pilot{
	@Override
	public void doFly() {
		System.out.println("flying.................");
	}
}
interface Docterr{
	public void doCure();
}
class Humann {
}
class AlopathyMedicalCollegee implements Docterr{
	@Override
	public void doCure() {
		System.out.println("alopathy cure logic implemented...");
	}
}
class AyurvedMedicalCollegee implements Docterr{
	@Override
	public void doCure() {
		System.out.println("ayurved cure logic implemented....");
	}
}
