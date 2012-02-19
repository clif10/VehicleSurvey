package com.myorg.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.myorg.data.Enums.Day;
import com.myorg.data.Enums.TimeInDay;

public class Util {

	
	
	public static Day getDayOfRun() {
		// TODO Auto-generated method stub
		return null;
	}

	public static Long getTimeInMiilisec(String stringInMillisec) {
		
		//Assuming that the first character will always be a string
		String timeInMillisecStr = stringInMillisec.substring(1);
		
		Long returnValue = Long.valueOf(timeInMillisecStr);
			
		return returnValue;
		
		
	}
	
	public static Calendar getTimeOfRun(Long timeInMillisec)
	{
		Calendar currentDate = Calendar.getInstance();
		currentDate.clear();
		
		Long referenceDateInMillisec = getReferenceDate().getTimeInMillis();
		Long currentMillisec = referenceDateInMillisec + timeInMillisec;
		currentDate.setTimeInMillis(currentMillisec);

		SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd,yyyy HH:mm:ss:SSS a");
		
		//System.out.println("today's  Date " + sdf.format(currentDate.getTime()));

		return currentDate;
		
	}
	
	public static int getTimeOfDay(Long timeInMillisec) 
	{
		//get the difference between the given time in milliseconds and the reference day
		
		Calendar currentDate = getTimeOfRun(timeInMillisec);
			
		SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd,yyyy HH:mm:ss:SSS a");
				
		//System.out.println("today's  Date " + sdf.format(currentDate.getTime()));
		
		return (currentDate.get(Calendar.AM_PM));
				
	}

	public static Calendar getReferenceDate()
	{
		Calendar referenceCalendar = Calendar.getInstance();
		
		referenceCalendar.clear();
		referenceCalendar.set(2012,01,13,0,0);

		SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd,yyyy HH:mm:ss:SSS a");

		//System.out.println("reference Date " + sdf.format(referenceCalendar.getTime()));

		return referenceCalendar;
	}

	public static Calendar getEndDate()
	{
		Calendar referenceCalendar = Calendar.getInstance();
		
		referenceCalendar.clear();
		referenceCalendar.set(2012,01,13,0,0);
		
		referenceCalendar.add(Calendar.DAY_OF_WEEK, 5);

		SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd,yyyy HH:mm:ss:SSS a");

		//System.out.println("end Date " + sdf.format(referenceCalendar.getTime()));

		return referenceCalendar;
	}

	public static int getDayOfRun(Long timeInMillisec) {
		Calendar currentDate = getTimeOfRun(timeInMillisec);
		
		SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd,yyyy HH:mm:ss:SSS a");
		
		//System.out.println("today's  Date " + sdf.format(currentDate.getTime()));

		int dayOfWeek = currentDate.get(Calendar.DAY_OF_WEEK) - 2; 
		
		return dayOfWeek; 
	}
	
	public static void printDate(String string, Calendar referenceCalendar)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd,yyyy HH:mm:ss:SSS a");

		System.out.println(" " + string +" " +sdf.format(referenceCalendar.getTime()));
	}

	public static String returnDateAsString(Calendar referenceCalendar)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd,yyyy HH:mm:ss:SSS a");

		return  sdf.format(referenceCalendar.getTime());
	}
	
}
