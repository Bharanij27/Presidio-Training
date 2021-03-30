package Invoice;

import java.time.LocalDate;

public enum Holidays{
	Jan1(1, 1), Jan26(1, 26), Aug15(8, 15), Oct2(10, 2);
	LocalDate date;
	
	Holidays(int month, int date){
		this.date = LocalDate.of(LocalDate.now().getYear(), month, date);
	}
	public LocalDate getDate() {
		return this.date;
	}
}