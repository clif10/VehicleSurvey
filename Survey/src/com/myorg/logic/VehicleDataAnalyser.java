package com.myorg.logic;

import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import com.myorg.data.Constants;
import com.myorg.data.VehicleData;
import com.myorg.data.Enums.TimeInDay;
import com.myorg.interfaces.IVehicleAnalyser;
import com.myorg.utils.Util;

public class VehicleDataAnalyser implements IVehicleAnalyser{

	/*
	 * Map to store data of the NorthBound Vehicles
	 * 
	 */	
	static Map<Integer, VehicleData> northBoundMap = null;
	
	/*
	 * Map to store data of the SouthBound Vehicles
	 * 
	 */	
	static Map<Integer, VehicleData> southBoundMap = null;
	
	static Map<Integer,Integer> countMapNorthBound = null;
	
	static Map<Integer,Integer> countMapSouthBound = null;

	static TreeMap<Integer, VehicleData> southBoundSortedMap = null;
	
	static TreeMap<Integer, VehicleData> northBoundSortedMap = null;

	public void setNorthBoundMap(Map<Integer, VehicleData> northBoundMap) {
		this.northBoundMap = northBoundMap;
		
	}

	public void setSouthBoundMap(Map<Integer, VehicleData> southBoundMap) {
		this.southBoundMap = southBoundMap;
		
	}

	public void setCountMapNorthBound(Map<Integer, Integer> countMapNorthBound) {
		this.countMapNorthBound = countMapNorthBound;
		
	}

	public void setCountMapSouthBound(Map<Integer, Integer> countMapSouthBound) {
		this.countMapSouthBound = countMapSouthBound;
		
	}

	public void setSortedMapNorthBound(TreeMap<Integer, VehicleData> northBoundSortedMap) {
		this.northBoundSortedMap = northBoundSortedMap;
		
	}

	public void setSortedMapSouthBound(TreeMap<Integer, VehicleData> southBoundSortedMap) {
		this.southBoundSortedMap = southBoundSortedMap;
		
	}
	public int getCountOfcarsInMorning() {

    	Util.printHeading(" Number of Cars in the Morning ");

    	Util.printSubHeading(" SouthBound and NorthBound ");

		int noInNorthbound = getCountOfcarsInMorningOrEvening(northBoundMap, TimeInDay.AM);
		int noInSouthbound = getCountOfcarsInMorningOrEvening(southBoundMap, TimeInDay.AM);
		
		int totalInMorning = noInSouthbound + noInNorthbound;
		
		System.out.println(" Count = " + totalInMorning);
		return totalInMorning;
		
	}

    public int getCountOfcarsInEvening() {
    	
    	Util.printHeading(" Number of Cars in the Evening ");

    	Util.printSubHeading(" SouthBound and NorthBound ");
		
		int noInNorthbound = getCountOfcarsInMorningOrEvening(northBoundMap, TimeInDay.PM);
		int noInSouthbound = getCountOfcarsInMorningOrEvening(southBoundMap, TimeInDay.PM);
		
		int totalInEvening = noInSouthbound + noInNorthbound;
		
		System.out.println(" Count = " + totalInEvening);
		return totalInEvening;
		
	}

	private int getCountOfcarsInMorningOrEvening(Map<Integer, VehicleData> directionMap, TimeInDay timeInDay) {
		
		int counter = 0;
		
		Iterator<Map.Entry<Integer, VehicleData>> entries = directionMap.entrySet().iterator();
		while (entries.hasNext()) 
		{ 
			Map.Entry<Integer, VehicleData> entry = entries.next(); 
/*			System.out.println("Key = " + entry.getKey());
			Util.printDate(" Date ", entry.getValue().getTimeOfRun());
*/
			if(timeInDay == entry.getValue().getTimeInDay())
				counter+=1;
		}
		return counter;
	}

	public Long getTimeSpansForMinutesToMillisec(int minutes)
	{
		return new Long(minutes*60*1000);
	}
	
	public void getCountOfCarsInTimeSpansofEveryHourSouthBound()
	{
		Util.printHeading(" Hourly Data ");

		Util.printSubHeading(" SouthBound Cars ");
		getCountOfcarsInTimeSpans(southBoundSortedMap, getTimeSpansForMinutesToMillisec(60),false);
		
		Util.printEndOfSection();
	}
	
	public void getCountOfCarsInTimeSpansofEveryHourNorthBound()
	{
		Util.printHeading(" Hourly Data ");
		
		Util.printSubHeading(" NorthBound Cars ");
		getCountOfcarsInTimeSpans(northBoundSortedMap, getTimeSpansForMinutesToMillisec(60),false);
				
		Util.printEndOfSection();
	}
	
	public void getCountOfCarsInTimeSpansofEveryThirtyMinutesSouthBound()
	{
		Util.printHeading(" Every Thirty Minutes Data ");

		Util.printSubHeading(" SouthBound Cars ");
		getCountOfcarsInTimeSpans(southBoundSortedMap, getTimeSpansForMinutesToMillisec(30),false);
		
		Util.printEndOfSection();
	}

	public void getCountOfCarsInTimeSpansofEveryThirtyMinutesNorthBound()
	{
		Util.printHeading(" Every Thirty Minutes Data ");

		Util.printSubHeading(" North Bound Cars ");
		getCountOfcarsInTimeSpans(northBoundSortedMap, getTimeSpansForMinutesToMillisec(30),false);
		
		Util.printEndOfSection();
	}

	public void getCountOfCarsInTimeSpansofEveryTwentyMinutesSouthBound()
	{
		Util.printHeading(" Every Twenty Minutes Data ");

		Util.printSubHeading(" SouthBound Cars ");
		getCountOfcarsInTimeSpans(southBoundSortedMap, getTimeSpansForMinutesToMillisec(20),false);
		
		Util.printEndOfSection();
	}

	public void getCountOfCarsInTimeSpansofEveryTwentyMinutesNorthBound()
	{
		Util.printHeading(" Every Twenty Minutes Data ");

		Util.printSubHeading(" North Bound Cars ");
		getCountOfcarsInTimeSpans(northBoundSortedMap, getTimeSpansForMinutesToMillisec(20),false);
		
		Util.printEndOfSection();
	}

	public void getCountOfCarsInTimeSpansofEveryFifteenMinutesSouthBound()
	{
		Util.printHeading(" Every Fifteen Minutes Data ");

		Util.printSubHeading(" SouthBound Cars ");
//		getCountOfcarsInTimeSpans(southBoundMap, getTimeSpansForMinutesToMillisec(15));
		getCountOfcarsInTimeSpans(southBoundSortedMap, getTimeSpansForMinutesToMillisec(15),false);
		
		Util.printEndOfSection();
	}

	public void getCountOfCarsInTimeSpansofEveryFifteenMinutesNorthBound()
	{
		Util.printHeading(" Every Fifteen Minutes Data ");

		Util.printSubHeading(" North Bound Cars ");
		getCountOfcarsInTimeSpans(northBoundSortedMap, getTimeSpansForMinutesToMillisec(15),false);
		
		Util.printEndOfSection();
	}
		
	/*
	 * Function to Get the number of cars in the range of a time interval.
	 * @param directionMap Map which contains the index and the vehicle data to be analysed
	 * @param timeSpanInMillisec time in milliseconds which is used to calculate the time spans
	 * 
	 */
	private int getCountOfcarsInTimeSpans(Map<Integer, VehicleData> directionMap, Long timeSpanInMillisec,
												boolean isAverageStorageRequired) {
		
		int counter = 0;
		 
		Iterator<Map.Entry<Integer, VehicleData>> entries = directionMap.entrySet().iterator();
		Long incrementalMilliSec = Util.getReferenceDate().getTimeInMillis() + timeSpanInMillisec;
		Calendar incrementingSecondCalendar = Util.getReferenceDate();
		incrementingSecondCalendar.setTimeInMillis(incrementalMilliSec);
		
		Calendar incrementingFirstCalendar = Util.getReferenceDate();
		Util.printDate(" First date  ", incrementingFirstCalendar);
		Util.printDate(" Second date  ", incrementingSecondCalendar);
		
			counter = 0;
			boolean isPrintedInfo = false;
			while (entries.hasNext()) 
			{ 
				Map.Entry<Integer, VehicleData> entry = entries.next(); 
				System.out.println("Key = " + entry.getKey());
				Util.printDate(" Date ", entry.getValue().getTimeOfRun());
				
				int lowerbBound = entry.getValue().getTimeOfRun().compareTo(incrementingFirstCalendar);
				int upperBound = entry.getValue().getTimeOfRun().compareTo(incrementingSecondCalendar);
				
				if(lowerbBound >= 0 && upperBound < 0)
				{
					counter++;
					if(isAverageStorageRequired)
							storeHourOfDayVehiclesNorthBound(
									incrementingFirstCalendar.get(Calendar.HOUR_OF_DAY));
					isPrintedInfo = false;
				}
				else
				{
					System.out.println("Number of cars between " + Util.returnDateAsString(incrementingFirstCalendar)
							+ " and " +Util.returnDateAsString(incrementingSecondCalendar) 
							+ " = " + counter);
					

					counter = 0;
					
					incrementingFirstCalendar.add(Calendar.MILLISECOND, timeSpanInMillisec.intValue());
					incrementingSecondCalendar.add(Calendar.MILLISECOND, timeSpanInMillisec.intValue());

					lowerbBound = entry.getValue().getTimeOfRun().compareTo(incrementingFirstCalendar);
					upperBound = entry.getValue().getTimeOfRun().compareTo(incrementingSecondCalendar);
					
					if(lowerbBound >= 0 && upperBound < 0)
					{
						counter++;
						if(isAverageStorageRequired)
							storeHourOfDayVehiclesNorthBound(
									incrementingFirstCalendar.get(Calendar.HOUR_OF_DAY));

						isPrintedInfo = false;
					}

					Util.printDate("Second Increment",incrementingSecondCalendar);
					Util.printDate("End Date",Util.getEndDate());
					
					if (incrementingSecondCalendar.compareTo(Util.getEndDate()) > 0)
					{
						isPrintedInfo = true;
						break;
					}
					
				}
			}
				if(!isPrintedInfo)
				{
					System.out.println("Number of cars between " + Util.returnDateAsString(incrementingFirstCalendar)
							+ " and " +Util.returnDateAsString(incrementingSecondCalendar) 
							+ " = " + counter);
				}
					
		return counter;
	}
	
	public void storeHourOfDayVehiclesNorthBound(int hourOfDay)
	{
		int currentCount;
				
		if(countMapNorthBound.containsKey(hourOfDay))
		{
		      currentCount = countMapNorthBound.get(hourOfDay);
		      countMapNorthBound.put(hourOfDay, ++currentCount);		      
		}
		else
			countMapNorthBound.put(hourOfDay, 1);		
	}

	public void storeHourOfDayVehiclesSouthBound(int hourOfDay)
	{
		int currentCount;
				
		if(countMapSouthBound.containsKey(hourOfDay))
		{
		      currentCount = countMapSouthBound.get(hourOfDay);
		      countMapSouthBound.put(hourOfDay, ++currentCount);		      
		}
		else
			countMapSouthBound.put(hourOfDay, 1);		
	}

	public void getAverageCountOfCarsInTimeSpansofEveryFifteenMinutesSouthBound()
	{
		Util.printHeading(" Average Count of Cars Every Fifteen Minutes Data for 5 days");

		Util.printSubHeading(" South Bound Cars ");
		
		countMapSouthBound = new TreeMap<Integer,Integer>();
		
		getCountOfcarsInTimeSpans(southBoundMap, getTimeSpansForMinutesToMillisec(15), true);
		
		Iterator<Map.Entry<Integer, Integer>> entries = countMapSouthBound.entrySet().iterator();
		
		Map.Entry<Integer,Integer> tempMap = null;
		while(entries.hasNext())
		{
			tempMap = entries.next();
			System.out.println(" Hour " + tempMap.getKey() );
			System.out.println("Value = " + tempMap.getValue());
			
			System.out.println(" The number of car in Hour " + 
									tempMap.getKey() + " = " +
									(tempMap.getValue())/Constants.NUMBEROFDAYSOFSURVEY); 
		}	
		
		Util.printEndOfSection();
	}
	
	public void getAverageCountOfCarsInTimeSpansofEveryFifteenMinutesNorthBound()
	{
		Util.printHeading(" Average Count of Cars Every Fifteen Minutes Data for 5 days");

		Util.printSubHeading(" North Bound Cars ");
		
		countMapNorthBound = new TreeMap<Integer,Integer>();
		
		getCountOfcarsInTimeSpans(northBoundMap, getTimeSpansForMinutesToMillisec(15), true);
		
		Iterator<Map.Entry<Integer, Integer>> entries = countMapNorthBound.entrySet().iterator();
		
		Map.Entry<Integer,Integer> tempMap = null;
		while(entries.hasNext())
		{
			tempMap = entries.next();
			System.out.println(" Hour " + tempMap.getKey() );
			System.out.println("Value = " + tempMap.getValue());
			
			System.out.println(" The number of car in Hour " + 
									tempMap.getKey() + " = " +
									(tempMap.getValue())/Constants.NUMBEROFDAYSOFSURVEY); 
		}	
		
		Util.printEndOfSection();
	}
	
	public void getPeakVolumeTimesNorthBound()
	{
		Util.printHeading(" Peak Volume Times Count of Cars Every Fifteen Minutes Data for 5 days");

		Util.printSubHeading(" North Bound Cars ");
		
		countMapNorthBound = new TreeMap<Integer,Integer>();
		
		getCountOfcarsInTimeSpans(northBoundMap, getTimeSpansForMinutesToMillisec(15), true);
		
		Iterator<Map.Entry<Integer, Integer>> entries = countMapNorthBound.entrySet().iterator();
		
		Map.Entry<Integer,Integer> tempMap = null;
		int prevPeakVolume = 0 ;
		int currentPeakVolume = 0 ;
		while(entries.hasNext())
		{
			tempMap = entries.next();
			currentPeakVolume  = tempMap.getValue();
			if (currentPeakVolume >= prevPeakVolume)
				prevPeakVolume = currentPeakVolume;
		}
		
		Iterator<Map.Entry<Integer, Integer>> entries1 = countMapNorthBound.entrySet().iterator();
		
		while(entries1.hasNext())
		{
			tempMap = entries1.next();
			if (prevPeakVolume == tempMap.getValue())
			System.out.println(" The Hour in the day that have peak volume of cars  " + 
				prevPeakVolume + " = " + (tempMap.getKey())); 
		}
		
		Util.printEndOfSection();
	}

	public void getPeakVolumeTimesSouthBound()
	{
		Util.printHeading(" Peak Volume Times Count of Cars Every Fifteen Minutes Data for 5 days");

		Util.printSubHeading(" South Bound Cars ");
		
		countMapSouthBound = new TreeMap<Integer,Integer>();
		
		getCountOfcarsInTimeSpans(southBoundMap, getTimeSpansForMinutesToMillisec(15), true);
		
		Iterator<Map.Entry<Integer, Integer>> entries = countMapSouthBound.entrySet().iterator();
		
		Map.Entry<Integer,Integer> tempMap = null;
		int prevPeakVolume = 0 ;
		int currentPeakVolume = 0 ;
		while(entries.hasNext())
		{
			tempMap = entries.next();
			currentPeakVolume  = tempMap.getValue();
			if (currentPeakVolume >= prevPeakVolume)
				prevPeakVolume = currentPeakVolume;
		}
		
		Iterator<Map.Entry<Integer, Integer>> entries1 = countMapSouthBound.entrySet().iterator();
		
		while(entries1.hasNext())
		{
			tempMap = entries1.next();
			if (prevPeakVolume == tempMap.getValue())
			System.out.println(" The Hour in the day that have peak volume of cars  " + 
				prevPeakVolume + " = " + (tempMap.getKey())); 
		}
		
		Util.printEndOfSection();
	}

}
