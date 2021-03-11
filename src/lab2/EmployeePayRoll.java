package lab2;

class Date{
	int date;
	int month;
	int year;
	
	Date(int date, int month, int year){
		this.date = date;
		this.month = month;
		this.year = year;
	}
	
	public String toString() {
		return this.date + "-" + this.month + "-" + this.year;
	}
}

class Employee{
	String name;
	String employeeId;
	Date dateOfJoining;
	double hoursWorked;
	
	public Employee(String name, String employeeId, int date, int month, int year, double hoursWorked) {
		this.name = name;
		this.employeeId = employeeId;
		this.dateOfJoining = new Date(date, month, year);
		this.hoursWorked = hoursWorked;
	}
}

class SalesPerson extends Employee {
	double hourlyPay = 500;
	double totalPay;
	
	public SalesPerson(String name, String employeeId, int date, int month, int year, double hoursWorked) {
		super(name, employeeId, date, month, year, hoursWorked);
		this.totalPay = hoursWorked * this.hourlyPay;
	}
	
	public double getSalary() {
		return this.totalPay;
	}
	
}

class Worker extends Employee {
	double hourlyPay = 1000;
	double totalPay;
	
	public Worker(String name, String employeeId, int date, int month, int year, double hoursWorked) {
		super(name, employeeId, date, month, year, hoursWorked);
		this.totalPay = hoursWorked * this.hourlyPay;
	}
	
	public double getSalary() {
		return this.totalPay;
	}
}

class SalesManger extends SalesPerson {
	double hourlyPay = 700;
	double totalPay;
	
	public SalesManger(String name, String employeeId, int date, int month, int year, double hoursWorked) {
		super(name, employeeId, date, month, year, hoursWorked);
		this.totalPay = hoursWorked * this.hourlyPay;
	}
	
	public double getSalary() {
		return this.totalPay;
	}
}

class SalesTerritoryManger extends SalesManger {
	double hourlyPay = 800;
	double totalPay;
	
	public SalesTerritoryManger(String name, String employeeId, int date, int month, int year, double hoursWorked) {
		super(name, employeeId, date, month, year, hoursWorked);
		this.totalPay = hoursWorked * this.hourlyPay;
	}
	
	public double getSalary() {
		return this.totalPay;
	}
}

public class EmployeePayRoll {
	public static void main(String[] args) {		
		SalesPerson salesperson = new SalesPerson("saler", "123", 10, 12, 2020, 110);
		SalesManger manager = new SalesManger("manager", "124", 4, 3, 2020, 106);
		SalesTerritoryManger territotyManager = new SalesTerritoryManger("territoryManger", "120", 3, 8, 2020, 120);
		Worker worker = new Worker("worker", "121", 9, 2, 2020, 102);
		System.out.println(salesperson.name + " salary is " + salesperson.getSalary());
		System.out.println(manager.name + " salary is " + manager.getSalary());
		System.out.println(territotyManager.name + " salary is " + territotyManager.getSalary());
		System.out.println(worker.name + " salary is " + worker.getSalary());
	}
}
