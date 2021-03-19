package lab3InheritanceException;

public class PayRoll {
	public static void main(String[] args) {
		Employee worker = new Worker();
		System.out.println(worker.calculateSalary());
	}
}


interface Employee{
	public double calculateSalary();
	public double workerTax();
}

abstract class Sales implements Employee{
	public double workerTax() {
		return 0.4;
	}
}


class SalesPerson extends Sales{
	private int salaryPerDay = 800;
	
	@Override
	public double calculateSalary() {
		return salaryPerDay * 30 - workerTax();
	}
}


class SalesManager extends Sales{
	private int salaryPerDay = 850;
	
	@Override
	public double calculateSalary() {
		return salaryPerDay * 30 * (salaryPerDay * 30 * workerTax());
	}
}

class SalesTerritoryManager extends Sales{
	private int salaryPerDay = 900;
	
	@Override
	public double calculateSalary() {
		return salaryPerDay * 30 * (salaryPerDay * 30 * workerTax());
	}
}

//  product
abstract class Prod implements Employee{	
	public double workerTax() {
		return 0.2;
	}
}

class Worker extends Prod{
	private int salaryPerDay = 1000;
	
	@Override
	public double calculateSalary() {
		return salaryPerDay * 30 -  (salaryPerDay * 30 * workerTax());
	}
}