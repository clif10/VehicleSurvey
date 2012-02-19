package com.myorg.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import javax.swing.text.html.HTMLDocument.HTMLReader.CharacterAction;

import com.myorg.data.Enums.Day;
import com.myorg.data.Enums.TimeInDay;
import com.myorg.data.VehicleData;
import com.myorg.utils.FileRead;
import com.myorg.utils.Util;

public class Surveyor {

	
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
	
	
	static TreeMap<Integer, VehicleData> southBoundSortedMap = null;
	
	static TreeMap<Integer, VehicleData> northBoundSortedMap = null;
	
	static List<String> carTimings = null;
	
	static int northBoundKey = 0;
	
	static int southBoundKey = 0;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		init();
		
		//fillCarTimingsfromFile(args[0]);
		fillCarTimings();
		
		readVehicleTimings();
		
		//TODO: sort on the values of the map if the file contents are not in sorted order
		
		mainMenu();
	}

	public static void mainMenu()
	{
		while (true) 
		{
			printMainMenu();
			int choice = readInt();   // make sure it's an int 
			switch (choice) {
			case 0: exit();
					break;
			case 1: getCountOfcarsInMorning();
					break;
			case 2: getCountOfcarsInEvening();
					break;
			case 3: getCountOfCarsInTimeSpansofEveryHourNorthBound();
					break;
			case 4: getCountOfCarsInTimeSpansofEveryHourSouthBound();
					break;
			case 5: getCountOfCarsInTimeSpansofEveryThirtyMinutesNorthBound();
					break;
			case 6: getCountOfCarsInTimeSpansofEveryThirtyMinutesSouthBound();
					break;
			case 7: getCountOfCarsInTimeSpansofEveryTwentyMinutesNorthBound();
					break;
			case 8: getCountOfCarsInTimeSpansofEveryTwentyMinutesSouthBound();
					break;					
			case 9: getCountOfCarsInTimeSpansofEveryFifteenMinutesNorthBound();
					break;
			case 10:getCountOfCarsInTimeSpansofEveryFifteenMinutesSouthBound();
					break;
			
			default: System.out.println("Wrong choice");
			}
	
		} 
	}

	private static void printMainMenu() {
		
		System.out.println("============================");
	    System.out.println("|   MENU SELECTION 		    |");
	    System.out.println("============================");
	    System.out.println("| Options:                                                            |");
	    System.out.println("|        1. Get Count of Cars in the Morning                          |");
	    System.out.println("|        2. Get Count of Cars in the Evening                          |");
	    System.out.println("|        3. Get Count of cars in North direction every hour           |");
	    System.out.println("|        4. Get Count of cars in South direction every hour           |");
	    System.out.println("|        5. Get Count of cars in North direction every 30 min         |");
	    System.out.println("|        6. Get Count of cars in South direction every 30 min         |");
	    System.out.println("|        7. Get Count of cars in North direction every 20 min         |");
	    System.out.println("|        8. Get Count of cars in South direction every 20 min         |");
	    System.out.println("|        9. Get Count of cars in North direction every 15 min         |");
	    System.out.println("|       10. Get Count of cars in South direction every 15 min         |");
	    System.out.println("============================");
	       
	}

	private static int readInt() {
		int inNumber = 0;
		System.out.flush();
		Scanner in = new Scanner(System.in);
		inNumber=in.nextInt();
  //       in.close();
	       System.out.println("Number is :"+inNumber);

		return inNumber;
		
	//	return Integer.valueOf(inString().trim()).intValue());
		
	}
	
	private static void exit() {
		printHeading("THANK YOU");
		System.exit(1);
		
		
	//	return Integer.valueOf(inString().trim()).intValue());
		
	}
	public static void create()
	{
		init();
		
		fillCarTimings();
		
		readVehicleTimings();
		
		
	}
	
	private static void fillCarTimingsfromFile(String fileName) {
		carTimings = new ArrayList<String>();
		
		carTimings = FileRead.readFile(fileName);
		
		
	}
	private static void fillCarTimings() {
		carTimings = new ArrayList<String>();
		
		carTimings.add("A604957");
		carTimings.add("B604960");
		carTimings.add("A605128");
		carTimings.add("B605132");
		
		carTimings.add("A268981");
		carTimings.add("A269123");
		carTimings.add("A1089807");
		carTimings.add("B1089810");
		carTimings.add("A1089948");
		carTimings.add("B1089951");

}
	
	
	private static void init() {
		northBoundMap = new HashMap<Integer, VehicleData>();
		southBoundMap = new HashMap<Integer, VehicleData>();
	}

	private static void readVehicleTimings() {
		//TODO: replace the for loop by reading from a file
		String firstReading = null;
		String secondReading = null;
		for (int firstIndex=0; firstIndex < 10 ; firstIndex++)
		{
			firstReading = carTimings.get(firstIndex);
			secondReading = carTimings.get(++firstIndex);
			
			if (secondReading.startsWith("B"))
			{
				invokeSouthBoundHandler(firstIndex);
				firstIndex+=2;
			}
			else
			{
				invokeNorthBoundHandler(firstIndex);
			}
		
		}
		
//		System.out.println("Cars in the morning are " + getCountOfcarsInMorning());
		
	}

	private static void invokeNorthBoundHandler(int firstIndex) {
		VehicleData vehicleData = createVehicleData(firstIndex,false);
		
		northBoundMap.put(++northBoundKey,vehicleData);
		northBoundSortedMap = 	new TreeMap<Integer, VehicleData>(northBoundMap);
	}

	/* The method should be able to check the container and find the difference between the 
	 * predessesor timing and the successor timing
	 * Hence A-B are the front wheels and the succeeding A-B pair are the rear wheels
	 * Hence the A(front wheel) and A(rear wheel) will give the difference
	 * 
	 * TODO: Do we also need to take care of two cars moving side by side
	 * 
	 */
	private static void invokeSouthBoundHandler(int firstIndex) {
		VehicleData vehicleData = createVehicleData(firstIndex,true);

		southBoundMap.put(++southBoundKey,vehicleData);
		southBoundSortedMap = 	new TreeMap<Integer, VehicleData>(southBoundMap); 
	
	}

	private static VehicleData createVehicleData(int firstIndex, boolean isSouthbound) {
		VehicleData vehicleData = new VehicleData();
		
		Long timeInMillisecFrontWheel = Util.getTimeInMiilisec(carTimings.get(firstIndex - 1));
		
		Long timeInMillisecRearWheel = null;
		if(isSouthbound)
		{
			timeInMillisecRearWheel = Util.getTimeInMiilisec(carTimings.get(firstIndex + 1));
		}
		else
		{
			timeInMillisecRearWheel = Util.getTimeInMiilisec(carTimings.get(firstIndex));
		}
		
		Long differenceInMilliSec = timeInMillisecRearWheel - timeInMillisecFrontWheel;
	
		vehicleData.setDifferenceInMillisec(differenceInMilliSec.intValue());
			
		vehicleData.setTimeInDay(TimeInDay.forValue(Util.getTimeOfDay(timeInMillisecFrontWheel)));
		
		vehicleData.setTimeOfRun(Util.getTimeOfRun(timeInMillisecFrontWheel));
		
		vehicleData.setDayOfRun(Day.forValue(Util.getDayOfRun(timeInMillisecFrontWheel)));
		
		return vehicleData;
	}

	public int getCountForNorthBound() {
		
		return northBoundMap.size();
	}

	public int getCountForSouthBound() 
	{
		
		return southBoundMap.size();
	}


	public static void getCountOfcarsMorningOrEvening()
	{
		getCountOfcarsInMorning();
		getCountOfcarsInEvening();
	}
	
	
    public static int getCountOfcarsInMorning() {

    	printHeading(" Number of Cars in the Morning ");

		printSubHeading(" SouthBound and NorthBound ");

		int noInNorthbound = getCountOfcarsInMorningOrEvening(northBoundMap, TimeInDay.AM);
		int noInSouthbound = getCountOfcarsInMorningOrEvening(southBoundMap, TimeInDay.AM);
		
		int totalInMorning = noInSouthbound + noInNorthbound;
		
		System.out.println(" Count = " + totalInMorning);
		return totalInMorning;
		
	}

    public static int getCountOfcarsInEvening() {
    	
    	printHeading(" Number of Cars in the Evening ");

		printSubHeading(" SouthBound and NorthBound ");
		
		int noInNorthbound = getCountOfcarsInMorningOrEvening(northBoundMap, TimeInDay.PM);
		int noInSouthbound = getCountOfcarsInMorningOrEvening(southBoundMap, TimeInDay.PM);
		
		int totalInEvening = noInSouthbound + noInNorthbound;
		
		System.out.println(" Count = " + totalInEvening);
		return totalInEvening;
		
	}

	private static int getCountOfcarsInMorningOrEvening(Map<Integer, VehicleData> directionMap, TimeInDay timeInDay) {
		
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

	public static Long getTimeSpansForMinutesToMillisec(int minutes)
	{
		return new Long(minutes*60*1000);
	}
	
	public static void getCountOfCarsInTimeSpansofEveryHourSouthBound()
	{
		printHeading(" Hourly Data ");

		printSubHeading(" SouthBound Cars ");
		getCountOfcarsInTimeSpans(southBoundSortedMap, getTimeSpansForMinutesToMillisec(60));
		
		printEndOfSection();
	}
	
	public static void getCountOfCarsInTimeSpansofEveryHourNorthBound()
	{
		printHeading(" Hourly Data ");
		
		printSubHeading(" NorthBound Cars ");
		getCountOfcarsInTimeSpans(northBoundSortedMap, getTimeSpansForMinutesToMillisec(60));
				
		printEndOfSection();
	}
	
	public static void getCountOfCarsInTimeSpansofEveryThirtyMinutesSouthBound()
	{
		printHeading(" Every Thirty Minutes Data ");

		printSubHeading(" SouthBound Cars ");
		getCountOfcarsInTimeSpans(southBoundSortedMap, getTimeSpansForMinutesToMillisec(30));
		
		printEndOfSection();
	}

	public static void getCountOfCarsInTimeSpansofEveryThirtyMinutesNorthBound()
	{
		printHeading(" Every Thirty Minutes Data ");

		printSubHeading(" North Bound Cars ");
		getCountOfcarsInTimeSpans(northBoundSortedMap, getTimeSpansForMinutesToMillisec(30));
		
		printEndOfSection();
	}

	public static void getCountOfCarsInTimeSpansofEveryTwentyMinutesSouthBound()
	{
		printHeading(" Every Twenty Minutes Data ");

		printSubHeading(" SouthBound Cars ");
		getCountOfcarsInTimeSpans(southBoundSortedMap, getTimeSpansForMinutesToMillisec(20));
		
		printEndOfSection();
	}

	public static void getCountOfCarsInTimeSpansofEveryTwentyMinutesNorthBound()
	{
		printHeading(" Every Twenty Minutes Data ");

		printSubHeading(" North Bound Cars ");
		getCountOfcarsInTimeSpans(northBoundSortedMap, getTimeSpansForMinutesToMillisec(20));
		
		printEndOfSection();
	}

	public static void getCountOfCarsInTimeSpansofEveryFifteenMinutesSouthBound()
	{
		printHeading(" Every Fifteen Minutes Data ");

		printSubHeading(" SouthBound Cars ");
//		getCountOfcarsInTimeSpans(southBoundMap, getTimeSpansForMinutesToMillisec(15));
		getCountOfcarsInTimeSpans(southBoundSortedMap, getTimeSpansForMinutesToMillisec(15));
		
		printEndOfSection();
	}

	public static void getCountOfCarsInTimeSpansofEveryFifteenMinutesNorthBound()
	{
		printHeading(" Every Fifteen Minutes Data ");

		printSubHeading(" North Bound Cars ");
		getCountOfcarsInTimeSpans(northBoundSortedMap, getTimeSpansForMinutesToMillisec(15));
		
		printEndOfSection();
	}
	
	private static void printHeading(String string) {
		System.out.println("---------------------------------------------------");
		System.out.println("----------   " + string.toUpperCase()+"  ----------");
		System.out.println("---------------------------------------------------");
				
	}
	private static void printSubHeading(String string) {
		
		System.out.println("*******   " + string.toUpperCase()+"  ******");
					
	}
	
	private static void printEndOfSection() {
		System.out.println("---------------------------------------------------\n");
				
	}
	
	/*
	 * Function to Get the number of cars in the range of a time interval.
	 * @param directionMap Map which contains the index and the vehicle data to be analysed
	 * @param timeSpanInMillisec time in milliseconds which is used to calculate the time spans
	 * 
	 */
	private static int getCountOfcarsInTimeSpans(Map<Integer, VehicleData> directionMap, Long timeSpanInMillisec) {
		
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
	
	
}
