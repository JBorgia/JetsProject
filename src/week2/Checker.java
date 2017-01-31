package week2;

import java.util.Calendar;

public class Checker {
	public static boolean validDay(int day, int month, int year) {
		boolean returned = true;
		int feb = 28;
		if (isLeapYear(year)) {
			feb = 29;
		}
		int monthDays[] = { 31, feb, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (day > 0 && day <= monthDays[month - 1]) {
			returned = false;
		}
		else{
			System.out.println("Day must be valid for the month (" + month + ") entered.");
		}
		return returned;
	} // checkDay

	public static boolean isLeapYear(int year) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		return cal.getActualMaximum(Calendar.DAY_OF_YEAR) > 365;
	} // isLeapYear
}
