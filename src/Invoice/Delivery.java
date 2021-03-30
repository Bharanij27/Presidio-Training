package Invoice;

import java.rmi.Naming;
import java.time.LocalDate;
import java.time.Month;

public class Delivery {
	public static void main(String[] args) throws Exception {
		PackageDeliveryEstimation delivery = (PackageDeliveryEstimation)Naming.lookup("rmi://localhost:4000/rmiservice/PdfConverter");
		LocalDate startingDay = LocalDate.of(2020, Month.DECEMBER, 31);
		delivery.initializeDelvery(startingDay, 300, 2, 5);
		System.out.println("Your package is estimated to delivered on " + delivery.calculateArrrival().toString());
	}
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