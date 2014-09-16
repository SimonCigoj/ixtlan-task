package si.ixtlan.view;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.joda.time.LocalDate;

import si.ixtlan.controller.CalendarController;
import si.ixtlan.model.Calendar;

/**
 * The JSF2.0 view managed bean backing the html gui.
 * 
 * The bean is view scoped so it preserves the state during post back to the same url.
 * 
 * @author simon
 *
 */
@ViewScoped
@ManagedBean
public class CalendarView {
	
	@Inject CalendarController calendarController;
	private Calendar calendar;
	
	private Date date = null;
	
	
	 @PostConstruct
	 public void initNewMember() {
		 calendar = new Calendar();
		 calendarController.reinitCalendar(calendar);
	 }
	 
	 public Calendar getCalendar(){
		 return calendar;
	 }

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public void reinitCalendar(){
		if(date != null){
			LocalDate submitedDate = new LocalDate(date.getTime());
			calendar.setMonth(submitedDate.getMonthOfYear());
			calendar.setYear(submitedDate.getYear());
		}
		calendarController.reinitCalendar(calendar);
		date = null;
	}
}
