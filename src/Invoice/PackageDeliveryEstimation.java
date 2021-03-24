package Invoice;

import java.time.LocalDate;

public interface PackageDeliveryEstimation {
	public LocalDate calculateArrrival();
	public double perDayTravel(double speed, int workHour);
	public boolean isHoliday(LocalDate date);
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