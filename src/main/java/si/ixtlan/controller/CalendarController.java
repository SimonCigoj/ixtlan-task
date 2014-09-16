package si.ixtlan.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.joda.time.DateTimeConstants;
import org.joda.time.LocalDate;

import si.ixtlan.model.Calendar;
import si.ixtlan.model.CalendarDay;

@Named
public class CalendarController {
	
	//inject holidays list
	@Inject private Map<String,String> holidays;
	
	/**
	 * This method initiates the calendar object that represents the calendar on gui.
	 * The calendar is being filled with CalendarDay objects that wraps the representation of a single day.
	 * 
	 * @param calendar the calendar object to initiate
	 */
	public void reinitCalendar(Calendar calendar){
		
		//get the first day to show in calendar
		LocalDate firstMonday = calendar.getFirstDayOfMonth().withDayOfWeek(DateTimeConstants.MONDAY);
		//get the last day to show in calendar
		LocalDate lastSunday = calendar.getLastDayOfMonth().withDayOfWeek(DateTimeConstants.SUNDAY);
		
		LocalDate date = firstMonday;
		
		//get the first and last week of year, handle the corner case when the last week shown in calendar goes in the next year
		int firstWeekNum = firstMonday.getWeekOfWeekyear();
		int lastWeekNum = (lastSunday.getWeekOfWeekyear() == 1)? calendar.getFirstDayOfMonth().weekOfWeekyear().getMaximumValue()+1 : lastSunday.getWeekOfWeekyear();
		
		calendar.getWeeks().clear();
		
		//loop trough weeks
		for(int i=firstWeekNum; i<=lastWeekNum; i++){
			List<CalendarDay> weekDays = new ArrayList<CalendarDay>();
			calendar.getWeeks().put(i, weekDays);
			
			//for each week fill in days data
			for (int j=1; j<=7; j++) {
			
				//check if the day is in the list of holidays
				String holidayDescription = checkIfHoliday(date);
				
				CalendarDay day = new CalendarDay(date);
				if(holidayDescription != null){
					day.setHoliday(true);
					day.setDescription(holidayDescription);
				}
				weekDays.add(day);
				date = date.plusDays(1);
			}
			
									
		}
	
	}
	
	/**
	 * This method checks if a given date is in the map of holidays.
	 * If the map key contains also the year value means that the holiday is not repeatable,
	 * otherwise the date repeats every year.
	 * 
	 * @param  date the date to check
	 * @return {@link String} the description of the holiday, if null is returned means there is no holiday on that day
	 */
	public String checkIfHoliday(LocalDate date){
		
		//search non repeatable holidays
		if(holidays.get(date.getDayOfMonth()+"."+date.getMonthOfYear()+"."+date.getYear()) != null){
			return holidays.get(date.getDayOfMonth()+"."+date.getMonthOfYear()+"."+date.getYear());
		}
		
		//search repeatable holidays
		if(holidays.get(date.getDayOfMonth()+"."+date.getMonthOfYear()+".") != null){
			return holidays.get(date.getDayOfMonth()+"."+date.getMonthOfYear()+".");
		}
		
		return null;
	}

}
