package funLab6;

public class VolumeOfBox {
	
	public static int volume(int l, int h, int w){
		return l*w*h;
	}
	
	public static void main(String[] args) {
		int l = 10, h = 20, w = 30;
		System.out.println(volume(l, h, w) + "cm");
	}
}
