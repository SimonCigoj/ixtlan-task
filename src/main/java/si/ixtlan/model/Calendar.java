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

public class Calendar {

	private LocalDate currentDate;
	private Map<Integer, List<CalendarDay>> weeks = new LinkedHashMap<Integer, List<CalendarDay>>();
	
	public Calendar() {
		currentDate = new LocalDate(new Date().getTime());
	}
	
	public LocalDate getFirstDayOfMont() {
		return currentDate.dayOfMonth().withMinimumValue();
	}
	
	public LocalDate getLastDayOfMont() {
		return currentDate.dayOfMonth().withMaximumValue();
	}
	
	public int getDaysInMonth() {
		return currentDate.dayOfMonth().getMaximumValue();
	}
	
	public LocalDate getCurrentDate() {
		return currentDate;
	}
	
	public void setCurrentDate(LocalDate currentDate) {
		this.currentDate = currentDate;
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
	
	public boolean isCurrentDate(LocalDate date){
		return date.equals(currentDate);
	}

		
}
