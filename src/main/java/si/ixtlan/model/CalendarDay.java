package si.ixtlan.model;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.LocalDate;

public class CalendarDay {

	private LocalDate date;
	private boolean isHoliday;
	
	public CalendarDay(LocalDate date) {
		this.date = date;
	}
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public boolean isHoliday() {
		return isHoliday;
	}
	public void setHoliday(boolean isHoliday) {
		this.isHoliday = isHoliday;
	}
	
	public boolean isWeekend(){
		return date.getDayOfWeek() == DateTimeConstants.SUNDAY || date.getDayOfWeek() == DateTimeConstants.SATURDAY;
	}
	
	public boolean isSunday(){
		return date.getDayOfWeek() == DateTimeConstants.SUNDAY;
	}
	
	
	
}
