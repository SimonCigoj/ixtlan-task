package si.ixtlan.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateMidnight;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

/**
 * The main calendar object that represents the gui state of the calendar.
 * @author simon
 *
 */
public class Calendar {

	private Integer year;
	private Integer month;
	
	private Map<Integer, List<CalendarDay>> weeks = new LinkedHashMap<Integer, List<CalendarDay>>();
	
	public Calendar() {
		LocalDate now = new LocalDate(new Date().getTime());
		month = now.getMonthOfYear();
		year = now.getYear();
	}
	
	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public LocalDate getFirstDayOfMonth() {
		return new LocalDate(year,month,1);
	}
	
	public LocalDate getLastDayOfMonth() {
		return getFirstDayOfMonth().dayOfMonth().withMaximumValue();
	}
	
	public int getDaysInMonth() {
		return getFirstDayOfMonth().dayOfMonth().getMaximumValue();
	}
	
	public Map<Integer, List<CalendarDay>> getWeeks() {
		return weeks;
	}

	public void setWeeks(Map<Integer, List<CalendarDay>> weeks) {
		this.weeks = weeks;
	}

	public List<Integer> getWeekNumbers(){
		return new ArrayList<Integer>(weeks.keySet());
	}
	
			
}
