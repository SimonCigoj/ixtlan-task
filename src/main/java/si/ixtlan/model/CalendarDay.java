package si.ixtlan.model;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.LocalDate;

/**
 * The object represents a single date in calendar and has some utility methods 
 * to easier handle day colors an other gui features.
 * @author simon
 *
 */
public class CalendarDay {

	private LocalDate date;
	private boolean isHoliday;
	private String description;
	
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public boolean isCurrentDate(){
		LocalDate today = new LocalDate(new Date().getTime());
		return date.equals(today);
	}
	
	public boolean isInMonth(int month){
		return date.getMonthOfYear() == month;
	}
	
	
	
}
