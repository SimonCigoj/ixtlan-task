package si.ixtlan.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.joda.time.DateTimeConstants;
import org.joda.time.LocalDate;

import si.ixtlan.model.Calendar;
import si.ixtlan.model.CalendarDay;

@Named
public class CalendarController {
	
	public void reinitCalendar(Calendar calendar){
		
		LocalDate firstMonday = calendar.getFirstDayOfMont().withDayOfWeek(DateTimeConstants.MONDAY);
		LocalDate lastSunday = calendar.getLastDayOfMont().withDayOfWeek(DateTimeConstants.SUNDAY);
		
		LocalDate date = firstMonday;
		int firstWeekNum = firstMonday.getWeekOfWeekyear();
		int lastWeekNum = lastSunday.getWeekOfWeekyear();
		
		calendar.getWeeks().clear();
		
		for(int i=firstWeekNum; i<=lastWeekNum; i++){
			List<CalendarDay> weekDays = new ArrayList<CalendarDay>();
			calendar.getWeeks().put(i, weekDays);
			for (int j=1; j<=7; j++) {
				System.out.println(date);
				
				weekDays.add(new CalendarDay(date));
				date = date.plusDays(1);
			}
			
									
		}
	
	}

}
