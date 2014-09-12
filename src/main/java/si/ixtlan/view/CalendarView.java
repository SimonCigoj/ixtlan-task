package si.ixtlan.view;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import si.ixtlan.controller.CalendarController;
import si.ixtlan.model.Calendar;

@ViewScoped
@Named
public class CalendarView {
	
	@Inject CalendarController calendarController;
	private Calendar calendar;
	private Integer year;
	private Integer month;
	private Date date;
	
	
	 @PostConstruct
	 public void initNewMember() {
		 calendar = new Calendar();
		 month = calendar.getCurrentDate().getMonthOfYear();
		 year = calendar.getCurrentDate().getYear();
		 calendarController.reinitCalendar(calendar);
	 }
	 
	 public Calendar getCalendar(){
		 return calendar;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
		 
}
