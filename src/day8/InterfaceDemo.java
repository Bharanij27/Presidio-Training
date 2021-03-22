package day8;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Scanner;

public class InterfaceDemo {
	public static void main(String[] args) {
		AlopathyMedicalCollege stanley=new AlopathyMedicalCollege();
		AyurvedMedicalCollege imcops=new AyurvedMedicalCollege();
		
		Human shoiab=new Human();//1974
	
		Doctorr doctorShoiab=(Doctorr)Proxy.newProxyInstance(shoiab.getClass().getClassLoader(),
								new Class[] {Doctorr.class},
								new MyInvocationHandler(imcops));
		doctorShoiab.doCure();
	}
}
class MyInvocationHandler implements InvocationHandler{
	Doctorr doctor;
	public MyInvocationHandler(Doctorr doctor) {
		this.doctor=doctor;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("method invoke invoked....");
		return method.invoke(doctor);
	}
}

interface Doctorr{
	public void doCure();
}
class Human {
}
class AlopathyMedicalCollege implements Doctorr{
	@Override
	public void doCure() {
		System.out.println("alopathy cure logic implemented...");
	}
}
class AyurvedMedicalCollege implements Doctorr{
	@Override
	public void doCure() {
		System.out.println("ayurved cure logic implemented....");
	}
}