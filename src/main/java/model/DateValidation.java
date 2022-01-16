package model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateValidation {
	
	static Date sql;
	
	public static boolean dateValidation(String date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		try {
			java.util.Date parsed = format.parse(date);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}
	
	public static Date getDate(String date) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		java.util.Date parsed;
		try {
			parsed = format.parse(date);
			sql = new Date(parsed.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sql;
	}
}
