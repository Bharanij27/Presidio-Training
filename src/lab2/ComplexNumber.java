package lab2;

public class ComplexNumber{
	   double real, img;
		
	   ComplexNumber(double r, double i){
		this.real = r;
		this.img = i;
	   }
		
	   public static ComplexNumber sum(ComplexNumber c1, ComplexNumber c2)
	   {
		   ComplexNumber temp = new ComplexNumber(0, 0);
	       temp.real = c1.real + c2.real;
	       temp.img = c1.img + c2.img;
	       return temp;
	    }
	   
	    public static void main(String args[]) {
	    	ComplexNumber c1 = new ComplexNumber(5.5, 4);
			ComplexNumber c2 = new ComplexNumber(1.2, 3.5);
			ComplexNumber temp = sum(c1, c2);
		    System.out.printf("Sum of two complex number is: "+ temp.real+"+i"+ temp.img);
		}
}