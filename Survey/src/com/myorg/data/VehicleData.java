package com.myorg.data;

import com.myorg.data.Enums.Day;
import com.myorg.data.Enums.TimeInDay;
import java.util.Calendar;


public class VehicleData {

	private int differenceInMillisec = 0;

	private Day dayOfRun = null; 
	
	private TimeInDay timeInDay = null;
	
	private Calendar timeOfRun = null;
	
	private int speed = 0;

	public int getDifferenceInMillisec()
	{
		return differenceInMillisec;
	}

	public Day getDayOfRun()
	{
		return dayOfRun;
	}
	
	public TimeInDay getTimeInDay()
	{
		return timeInDay;
	}
	
	public Calendar getTimeOfRun()
	{
		return timeOfRun;
	}
	
	public int getSpeed()
	{
		return speed;
	}
	
	public void setDifferenceInMillisec(int differenceInMillisec)
	{
		this.differenceInMillisec = differenceInMillisec;
	}
	
	public void setDayOfRun(Day dayOfRun)
	{
		this.dayOfRun = dayOfRun;
	}
	
	public void setTimeInDay(TimeInDay timeInDay)
	{
		this.timeInDay = timeInDay;
	}
	
	public void setTimeOfRun(Calendar timeOfRun)
	{
		this.timeOfRun = timeOfRun;
	}
	
	public void setSpeed(int speed)
	{
		this.speed = speed;
	}
	
	
	
}
