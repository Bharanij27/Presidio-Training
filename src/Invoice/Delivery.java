package Invoice;

import java.rmi.Naming;
import java.time.LocalDate;
import java.time.Month;
import java.util.Iterator;
import java.util.Map;

public class Delivery {
	public static void main(String[] args) throws Exception {
		PackageDeliveryEstimation delivery = (PackageDeliveryEstimation)Naming.lookup("rmi://localhost:4010/rmiservice/PackageDeliveryEstimation");
		Map<Integer, Object> data = new XmlToData().toCollection();
		for (Map.Entry<Integer,Object> entry : data.entrySet()) {			
			Order d = (Order) entry.getValue();
			delivery.initializeDelvery(d.getOrderDate(), d.getDistance(), d.getSpeed(), d.getWorkHour());
			System.out.println("Your package is estimated to delivered on " + delivery.calculateArrrival().toString());
		}
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