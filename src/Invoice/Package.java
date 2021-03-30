package Invoice;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;

import day16.RmiService;

public class Package extends UnicastRemoteObject implements PackageDeliveryEstimation{
	
	protected Package() throws RemoteException {
		// TODO Auto-generated constructor stub
	}

	LocalDate date;
	double distance, distanceReamining;
	double distancePerDay;

	
	@Override
	public void initializeDelvery(LocalDate orderDate, double distance, double speed, int workHour) throws RemoteException {
		this.date = orderDate;
		this.distance = distance;
		this.distanceReamining = distance;
		this.distancePerDay = perDayTravel(speed, workHour);
	}
	
	@Override
	public double perDayTravel(double speed, int workHour) throws RemoteException {
		return speed * workHour;
	}
	
	@Override
	public LocalDate calculateArrrival() throws RemoteException {
		LocalDate today = date.plusDays(1);
		while(this.distanceReamining > 0) {
			
			if(!isHoliday(today)) {
				this.distanceReamining -= this.distancePerDay;
				//System.out.println("can deliver on " + today.toString() +  "  " +isHoliday(today));
			}
			//else	System.out.println("can't deliver on " + today.toString() + "  " + isHoliday(today));
			today = today.plusDays(1);
		}
		return today;
	}
	
	@Override
	public boolean isHoliday(LocalDate date) throws RemoteException {
		
		if("SUNDAY".equalsIgnoreCase(date.getDayOfWeek().toString())) return true;
		
		Holidays[] h = Holidays.values();
		for(Holidays i : h) {
			if(i.date.getMonthValue() == date.getMonthValue() && i.date.getDayOfMonth() == date.getDayOfMonth()) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args)throws Exception {
		Package rmiService = new Package();
		LocateRegistry.createRegistry(4010);		
		
		System.out.println("Server Ready....");
		Naming.bind("rmi://localhost:4010/rmiservice/PackageDeliveryEstimation", rmiService);
	}
}