package ro.eduardharis.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateService {

	public static Calendar stringToDateHtml(String dateString) throws ParseException {
		Calendar date = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		date.setTime(format.parse(dateString));
		System.out.println(getDate(date));
		return date;
	}
	
	public static Calendar stringToDateDatabase(String dateString) throws ParseException {
		Calendar date = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		date.setTime(format.parse(dateString));
		System.out.println(getDate(date));
		return date;
	}

	private static String getDate(Calendar date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		dateFormat.setTimeZone(date.getTimeZone());
		return dateFormat.format(date.getTime());
	}

}
