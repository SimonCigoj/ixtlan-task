package si.ixtlan.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

@ApplicationScoped
public class HolidaysReader {
	
	//the map that holds the holiday data, map is used for better performance  
	private Map<String,String> holidays = new HashMap<String,String>();

	/**
	 * Initiate the map of holidays. 
	 * Reeds the csv file holiday.csv which has entries of holidays ant their description.
	 * The entries are of two types:
	 * 1.) non repeatable entries like dd.mm.yyyy=holiday name
	 * 2.) repeatable entries like dd.mm.=holiday name
	 * 
	 * The difference is that the repeatable entries has no year value, because they occur every 
	 * year on the same day.
	 * 
	 * The value is stored in APPLICATION SCOPE so it is retrievable and injectable in the whole 
	 * Application life cycle.	 * 
	 */
	@PostConstruct
	private void init(){
		try {
			InputStream in = getClass().getResourceAsStream("/holiday.csv");
			BufferedReader reader = new BufferedReader(new InputStreamReader(in,"UTF-8"));
			
			String line = reader.readLine();
			
			while (line != null) {
				//split each holiday entry which is divided by a coma ,
				String[] splitedLine = line.split(",");
				
				//for each entry split the date and the description
				for (String holiday :splitedLine){
					String[] splitedHoliday = holiday.split("=");
					//the key of the map is the date value, used like this 
					//for faster retrieval, and easier checking if some date is holiday
					holidays.put(splitedHoliday[0],splitedHoliday[1]);
				}
				line = reader.readLine();
			}	
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Produces the holiday map so it can be injected in other beans via CDI
	 * @return Map<String,String> 
	 */
	@Produces
	@Named
	public Map<String, String> getHolidays() {
		return holidays;
	}

}
