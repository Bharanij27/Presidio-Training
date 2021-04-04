package Invoice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDateTime;

public interface PackageDeliveryEstimation extends Remote{
	public String calculateArrrival() throws RemoteException ;
	public double perDayTravel(double speed, int workHour) throws RemoteException ;
	public boolean isHoliday(LocalDateTime date) throws RemoteException ;
	public void initializeDelvery(LocalDateTime orderDate, double distance, double speed, int workHour) throws RemoteException;
}

/*
 * Start Date and Time
Distance
Travel speed
No of hrs working per day
holiday -list will come in enum (night 12 to 12 - 24 hrs)
sunday,jan1, jan26,aug 15,oct2
Calculate the date and time of delivery
 */