package day3; 

class Base{
private void amethod(int iBase){
        System.out.println("Base.amethod");
        }
}

class JavaTest extends Base{


public static void main(String argv[]){
	JavaTest o = new JavaTest();
        int iBase=0;
        o.amethod(iBase);
        }
        public void amethod(int iOver){
                System.out.println("Over.amethod");
        }

}