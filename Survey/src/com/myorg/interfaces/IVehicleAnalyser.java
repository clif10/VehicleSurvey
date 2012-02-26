package com.myorg.interfaces;


public interface IVehicleAnalyser {
	
	public int getCountOfcarsInMorning();
    
	public int getCountOfcarsInEvening() ;
	
	public Long getTimeSpansForMinutesToMillisec(int minutes);
	
	public void getCountOfCarsInTimeSpansofEveryHourSouthBound();
	
	public void getCountOfCarsInTimeSpansofEveryHourNorthBound();
	
	public void getCountOfCarsInTimeSpansofEveryThirtyMinutesSouthBound();
	
	public void getCountOfCarsInTimeSpansofEveryThirtyMinutesNorthBound();
	
	public void getCountOfCarsInTimeSpansofEveryTwentyMinutesSouthBound();
	
	public void getCountOfCarsInTimeSpansofEveryTwentyMinutesNorthBound();
	
	public void getCountOfCarsInTimeSpansofEveryFifteenMinutesSouthBound();
	
	public void getCountOfCarsInTimeSpansofEveryFifteenMinutesNorthBound();
	
	public void storeHourOfDayVehiclesNorthBound(int hourOfDay);
	
	public void storeHourOfDayVehiclesSouthBound(int hourOfDay);
	
	public void getAverageCountOfCarsInTimeSpansofEveryFifteenMinutesSouthBound();
	
	public void getAverageCountOfCarsInTimeSpansofEveryFifteenMinutesNorthBound();
	
	public void getPeakVolumeTimesNorthBound();
	
	public void getPeakVolumeTimesSouthBound();

}
