package Invoice;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


public class Package extends UnicastRemoteObject implements PackageDeliveryEstimation{
	
	protected Package() throws RemoteException {
		// TODO Auto-generated constructor stub
	}

	LocalDateTime date;
	double distance, distanceReamining;
	double distancePerDay;
	double speed;
	
	@Override
	public void initializeDelvery(LocalDateTime orderDate, double distance, double speed, int workHour) throws RemoteException {
		this.date = orderDate;
		this.distance = distance;
		this.distanceReamining = distance;
		this.speed  = speed;
		this.distancePerDay = perDayTravel(speed, workHour);
	}
	
	@Override
	public double perDayTravel(double speed, int workHour) throws RemoteException {
		return speed * workHour;
	}
	
	@Override
	public String calculateArrrival() throws RemoteException {
		LocalDateTime today = this.date;
		long time  = 0;
		while(this.distanceReamining > 0 ) {
			
			if(!isHoliday(today)) {
				if(this.distanceReamining <= this.distancePerDay) time = calculateTime(this.distanceReamining);
				this.distanceReamining -= this.distancePerDay; 
			}
			if(distanceReamining > 0) today = today.plusDays(1);
		}
		today = today.plus(time, ChronoUnit.SECONDS);  
		return today.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")).toString();
	}
	
	public long calculateTime(double distance) {
		double time = distance / this.speed;
		System.out.println((long) (time * 60 *60));
		return (long) (time * 60 *60);
	}

	@Override
	public boolean isHoliday(LocalDateTime date) throws RemoteException {
		
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