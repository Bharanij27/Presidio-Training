package lab2;

class Singleton 
{ 
    private static Singleton single_instance = null; 
  
    public int num; 
  
    private Singleton() 
    { 
       num = 10; 
    } 
  
    public static Singleton createInstance() 
    { 
        if (single_instance == null) 
            single_instance = new Singleton(); 
  
        return single_instance; 
    } 
} 
  
public class SingletonClass { 
    public static void main(String args[]) 
    { 
        Singleton x = Singleton.createInstance(); 
        Singleton y = Singleton.createInstance(); 
        Singleton z = Singleton.createInstance(); 
  
        System.out.println("String from x is " + x.num); 
        System.out.println("String from y is " + y.num); 
        System.out.println("String from z is " + z.num); 
  
        z.num = 100;
        System.out.println("Changing value on one object reflects on others ");   
        System.out.println("String from x is " + x.num); 
        System.out.println("String from y is " + y.num); 
        System.out.println("String from z is " + z.num); 
    } 
} 
