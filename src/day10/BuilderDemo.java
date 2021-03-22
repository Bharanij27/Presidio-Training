package day10;


public class BuilderDemo {
	public static void main(String[] args) throws Exception {
		Computer myComputer= Computer.ComputerBuilder.createObject("i7 core processor","12gb").build();
		
		System.out.println(myComputer);
		
		Computer myCom2= Computer.ComputerBuilder.createObject("18 core proccsss","16gb ram").setGraphicsCard("graphics card")
											.setHdd("my new hdd").build();
		
		System.out.println(myCom2);
	}
}

class Computer implements Cloneable {
	private static Computer instance;
	private static ComputerBuilder cb;
	
	//fixed properties
	private String motherBoard;
	private String ram;
	public String getMotherBoard() {
		return motherBoard;
	}
	public void setMotherBoard(String motherBoard) {
		this.motherBoard = motherBoard;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public String getGraphicsCard() {
		return graphicsCard;
	}
	public void setGraphicsCard(String graphicsCard) {
		this.graphicsCard = graphicsCard;
	}
	public String getHdd() {
		return hdd;
	}
	public void setHdd(String hdd) {
		this.hdd = hdd;
	}

	//optional Properties
	private String graphicsCard;
	private String hdd;
	
	@Override
	public String toString() {
		return "Computer [motherBoard=" + motherBoard + ", ram=" + ram + ", graphicsCard=" + graphicsCard + ", hdd="
				+ hdd + "]";
	}
	public Computer(ComputerBuilder builder) {
		System.out.println("Computer");
		this.motherBoard=builder.motherBoard;
		this.ram=builder.ram;
		this.graphicsCard=builder.getGraphicsCard();
		this.hdd=builder.getHdd();
	}
	
	synchronized public static Computer createObject(ComputerBuilder cb) throws Exception{
		if(instance == null) {
			instance = new Computer(cb);
		}
		return instance.createClone(cb);		
	}

	public Computer createClone(ComputerBuilder cb) throws Exception{
			Computer newComputer = (Computer) super.clone();		
			newComputer.setHdd(cb.hdd);
			newComputer.setGraphicsCard(cb.graphicsCard);
			return newComputer;
	}
	
	public static class ComputerBuilder implements Cloneable{
		
		//fixed properties
		private String motherBoard;
		private String ram;
		//optional Properties
		private String graphicsCard;
		private String hdd;
		
		private ComputerBuilder(String motherBoard,String ram) {
			System.out.println("Computer Builder");
			this.motherBoard=motherBoard;
			this.ram=ram;
		}
		
		synchronized public static ComputerBuilder createObject(String motherBoard,String ram) throws Exception{
			if(cb == null) {
				cb = new ComputerBuilder(motherBoard, ram);
			}
			return cb.createClone();		
		}

		public ComputerBuilder createClone() throws Exception{	
				return (ComputerBuilder) super.clone();		
		}
		
		public String getGraphicsCard() {
			return graphicsCard;
		}
		public ComputerBuilder setGraphicsCard(String graphicsCard) {
			this.graphicsCard = graphicsCard;
			return this;
		}
		public String getHdd() {
			return hdd;
		}
		public ComputerBuilder setHdd(String hdd) {
			this.hdd = hdd;
			return this;
		}
		
		public Computer build() throws Exception {
			return Computer.createObject(this);
		}
	}
}