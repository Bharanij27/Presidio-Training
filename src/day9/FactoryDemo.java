package day9;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Scanner;

public class FactoryDemo {
	public static void main(String[] args) throws Exception{
		ShoeSeller seller = Container.getShoeSeller();
		Shoe shoe = seller.sellShoe();
		System.out.println(shoe);
		
		Scanner s = new Scanner(System.in);
		s.next();
		
		Importer importObj = new ImportImpl();
		Object obj = Proxy.newProxyInstance(seller.getClass().getClassLoader(),
				new Class[] {ShoeSeller.class,Importer.class},
				new MyInvocationHandler(new Object[] {seller,importObj}));
		ShoeSeller shop=(ShoeSeller)obj;
		System.out.println(shop.sellShoe());
		Importer importer=(Importer)obj;
		importer.doImport();
		
		Exporter exporter = new ExportImple();
		
		obj=Proxy.newProxyInstance(seller.getClass().getClassLoader(),
				new Class[] {ShoeSeller.class, Importer.class, Exporter.class},
				new MyInvocationHandler(new Object[] {obj, exporter}));
		Exporter exportShoe = (Exporter)obj;
		exportShoe.doExport();
		System.out.println("............");
		importer=(Importer)obj;
		importer.doImport();
	}	
}


class Container{
	public static ShoeSeller getShoeSeller() throws Exception{
		ShoeShop seller = (ShoeShop)Class.forName("day9.SibiShoeShop").getConstructor().newInstance();
		ShoeManufacturer manufacturer = (ShoeManufacturer)Class.forName("day9.BataShoe").getConstructor().newInstance();
		seller.setManufacturer(manufacturer);
		return seller;
	}
}

interface Importer{
	public void doImport();
}


interface Exporter{
	public void doExport();	
}

class ExportImple implements Exporter{
	@Override
	public void doExport() {
		System.out.println("Exporting shoe.....");
	}
}

class ImportImpl implements Importer{
	@Override
	public void doImport() {
		System.out.println("Importing.............");
	}
}

class MyInvocationHandler implements InvocationHandler{
	Object obj[];
	public MyInvocationHandler(Object obj[]) {
		this.obj=obj;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object returnObject=null;
	 	for(Object o:obj) {
			Method m[]=o.getClass().getDeclaredMethods();
			for(Method met:m) {
				if(met.getName().equals(method.getName())) {
					met.setAccessible(true);
					returnObject=method.invoke(o, args);
				}
			}
		}
		return returnObject;
	}
}



// Seller 
interface Seller{
	
}

interface ShoeSeller extends Seller{
	public Shoe sellShoe();
}

abstract class ShoeShop implements ShoeSeller{
	public ShoeShop() {
		// TODO Auto-generated constructor stub
	}
	
	private ShoeManufacturer manufacturer;

	public ShoeManufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(ShoeManufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}
}


class SibiShoeShop extends ShoeShop{
	public SibiShoeShop() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Shoe sellShoe() {
		return getManufacturer().MakeShoe();
	}
}

// Manufacturer

interface Manufacturer{
	
}

interface ShoeManufacturer extends Manufacturer{
	public Shoe MakeShoe();
}

abstract class ShoeFactory implements ShoeManufacturer{
	
}

class BataShoe extends ShoeFactory{
	
	public BataShoe() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Shoe MakeShoe() {
		return new LeatherShoe();
	}
}


class ParagonShoe extends ShoeFactory{
	
	public ParagonShoe() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Shoe MakeShoe() {
		return new SportsShoe();
	}
}



// Shoe

abstract class Shoe{	
}

class LeatherShoe extends Shoe{
}


class SportsShoe extends Shoe{
}
