package Invoice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class Delivery {
	public static void main(String[] args) {
		LocalDate startingDay = LocalDate.of(2020, Month.DECEMBER, 31);
		Package p = new Package(startingDay, 300, 2, 5);
		System.out.println("Your package is estimated to delivered on " + p.calculateArrrival().toString());
	}
}


class Package implements PackageDeliveryEstimation{
	LocalDate date;
	double distance, distanceReamining;
	double distancePerDay;
	
	public Package(LocalDate orderDate, double distance, double speed, int workHour) {
		this.date = orderDate;
		this.distance = distance;
		this.distanceReamining = distance;
		this.distancePerDay = perDayTravel(speed, workHour);
	}
	
	@Override
	public double perDayTravel(double speed, int workHour) {
		return speed * workHour;
	}
	
	@Override
	public LocalDate calculateArrrival() {
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
	public boolean isHoliday(LocalDate date) {
		
		if("SUNDAY".equalsIgnoreCase(date.getDayOfWeek().toString())) return true;
		
		Holidays[] h = Holidays.values();
		for(Holidays i : h) {
			if(i.date.getMonthValue() == date.getMonthValue() && i.date.getDayOfMonth() == date.getDayOfMonth()) {
				return true;
			}
		}
		return false;
	}
	
}



enum Holidays{
	Jan1(1, 1), Jan26(1, 26), Aug15(8, 15), Oct2(10, 2);
	LocalDate date;
	
	Holidays(int month, int date){
		this.date = LocalDate.of(LocalDate.now().getYear(), month, date);
	}
	public LocalDate getDate() {
		return this.date;
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