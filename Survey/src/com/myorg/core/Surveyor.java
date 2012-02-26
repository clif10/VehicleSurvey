package com.myorg.core;


import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import com.myorg.data.Enums.Day;
import com.myorg.data.Enums.TimeInDay;
import com.myorg.data.VehicleData;
import com.myorg.logic.VehicleDataAnalyser;
import com.myorg.utils.FileRead;
import com.myorg.utils.Util;

/*
 * This class will orchestra the reading of the survey data,
 * accepting user inputs and invoking the clas which can analyse this information
 * 
 */
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
	
	/*
	 * Map to store data of the SouthBound Vehicles in sorted order for the key
	 * 
	 */
	static TreeMap<Integer, VehicleData> southBoundSortedMap = null;

	/*
	 * Map to store data of the NorthBound Vehicles in sorted order for the key
	 * 
	 */
	static TreeMap<Integer, VehicleData> northBoundSortedMap = null;

	/*
	 * Map to store the count of the NorthBound Vehicles
	 */
	static Map<Integer,Integer> countMapNorthBound = null;
	/*
	 * Map to store the count of the SouthBound Vehicles
	 */
	static Map<Integer,Integer> countMapSouthBound = null;
	
	/*
	 * List to store the cartimings after being read from a source
	 */
	static List<String> carTimings = null;
	
	
	static int northBoundKey = 0;
	
	static int southBoundKey = 0;

	/**
	 * @param args accepts the name and path of the file names containing the 
	 * survey data
	 */
	public static void main(String[] args) {
		
		init();
		
		fillCarTimingsfromFile(args[0]);
		//call this method if the data has to be populated locally
		//fillCarTimings();
		
		readVehicleTimings();
		
		//TODO: sort on the values of the map if the file contents are not in sorted order
		
		mainMenu();
	}

	/*
	 * Method to invoke the vehicle readings processor and the printing of the main menu on the
	 *  console
	 */
	public static void mainMenu()
	{
		VehicleDataAnalyser vehicleDataAnalyser = new VehicleDataAnalyser();
		vehicleDataAnalyser.setNorthBoundMap(northBoundMap);
		vehicleDataAnalyser.setSouthBoundMap(southBoundMap);
		vehicleDataAnalyser.setCountMapNorthBound(countMapNorthBound);
		vehicleDataAnalyser.setCountMapSouthBound(countMapSouthBound);
		vehicleDataAnalyser.setSortedMapNorthBound(northBoundSortedMap);
		vehicleDataAnalyser.setSortedMapSouthBound(southBoundSortedMap);
		while (true) 
		{
			printMainMenu();
			int choice = readInt();   // make sure it's an int 
			switch (choice) {
			case 0: exit();
					break;
			case 1: vehicleDataAnalyser.getCountOfcarsInMorning();
					break;
			case 2: vehicleDataAnalyser.getCountOfcarsInEvening();
					break;
			case 3: vehicleDataAnalyser.getCountOfCarsInTimeSpansofEveryHourNorthBound();
					break;
			case 4: vehicleDataAnalyser.getCountOfCarsInTimeSpansofEveryHourSouthBound();
					break;
			case 5: vehicleDataAnalyser.getCountOfCarsInTimeSpansofEveryThirtyMinutesNorthBound();
					break;
			case 6: vehicleDataAnalyser.getCountOfCarsInTimeSpansofEveryThirtyMinutesSouthBound();
					break;
			case 7: vehicleDataAnalyser.getCountOfCarsInTimeSpansofEveryTwentyMinutesNorthBound();
					break;
			case 8: vehicleDataAnalyser.getCountOfCarsInTimeSpansofEveryTwentyMinutesSouthBound();
					break;				
			case 9: vehicleDataAnalyser.getCountOfCarsInTimeSpansofEveryFifteenMinutesNorthBound();
					break;
			case 10:vehicleDataAnalyser.getCountOfCarsInTimeSpansofEveryFifteenMinutesSouthBound();
					break;
			
			default: System.out.println("Wrong choice");
			}
	
		} 
	}

	/*
	 * Method to print the main menu on the console
	 */
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
        System.out.println("Number is :"+inNumber);
		return inNumber;
			
	}
	
	private static void exit() {
		Util.printHeading("THANK YOU");
		System.exit(1);
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
		
		//System.out.println("Cars in the morning are " + getCountOfcarsInMorning());
		
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


	/*public static void getCountOfcarsMorningOrEvening()
	{
		getCountOfcarsInMorning();
		getCountOfcarsInEvening();
	}*/
	
}
