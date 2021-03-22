package day5;
import java.util.Scanner;
public class ShaitanDemo {
	public static void main(String[] args) {
		Fan fan = new Fan();
		while(true) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter to pull the chain...");
			scan.next();
			fan.pull();
		}
	}
}

class Fan{
	FanState fanState;
	
	Fan(){
		fanState = new FanOff();
	}
	
	void setState(FanState fanState){
		this.fanState = fanState;
	}
	public void pull() {
		fanState.changeState(this);
	}
}


abstract class FanState{
	int state = 0;
	abstract void changeState(Fan fan);
}



class FanOff extends FanState{

	FanOff(){
		state  = 0;
		System.out.println("switch off state.....");
	}
	
	void changeState(Fan fan) {
		fan.setState(new FanOn());
	}	
}


class FanOn extends FanState{

	FanOn(){
		state  = 1;
		System.out.println("switch on state.....");
	}
	
	void changeState(Fan fan) {
		fan.setState(new SpeedMedium());
	}
}


class SpeedMedium extends FanState{
	SpeedMedium(){
		state  = 2;
		System.out.println("Medium speed state.....");
	}
	
	void changeState(Fan fan) {
		fan.setState(new SpeedHigh());
	}
}


class SpeedHigh extends FanState{
	SpeedHigh(){
		state  = 3;
		System.out.println("High speed state.....");
	}
	
	void changeState(Fan fan) {
		fan.setState(new UltraSpeedHigh());
	}
}


class UltraSpeedHigh extends FanState{
	UltraSpeedHigh(){
		state  = 4;
		System.out.println("Ultra High speed state.....");
	}
	
	void changeState(Fan fan) {
		fan.setState(new FanOff());
	}
}