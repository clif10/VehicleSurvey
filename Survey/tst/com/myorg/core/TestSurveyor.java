package com.myorg.core;

import junit.framework.Assert;

import org.junit.Test;

import com.myorg.logic.VehicleDataAnalyser;

public class TestSurveyor {
	
	VehicleDataAnalyser vehicleDataAnalyser = null;
	
	/*@Test
	public void testCountForNorthBound() {
 
		this.setup();
		
		Assert.assertEquals(vehicleDataAnalyser.getCountForNorthBound() , 2);
 
	}
*/
/*	@Test
	public void testgetCountOfcarsInMorning() {
 		this.setup();
		
		Assert.assertEquals(vehicleDataAnalyser.getCountOfcarsInMorning(), 3);
 
	}
*/
	/*@Test
	public void testgetCountOfCarsInTimeSpansofEveryHour(){
		
		this.setUp();
		
		vehicleDataAnalyser.getCountOfCarsInTimeSpansofEveryFifteenMinutesNorthBound(); 
	}*/
	
	@Test
	public void testgetgetCountOfCarsInTimeSpansofEveryHour(){
		
		this.setUp();
		
		vehicleDataAnalyser.getAverageCountOfCarsInTimeSpansofEveryFifteenMinutesNorthBound();
		
		vehicleDataAnalyser.getPeakVolumeTimesNorthBound();
		
	}
	
	@Test
	public void testgetgetCountOfCarsInTimeSpansofEveryHourSouthBound(){
		
		this.setUp();
		
		vehicleDataAnalyser.getAverageCountOfCarsInTimeSpansofEveryFifteenMinutesSouthBound();
		
		vehicleDataAnalyser.getPeakVolumeTimesSouthBound();
		
	}
	
	private void setUp()
	{
	
	Surveyor.create();
	
	vehicleDataAnalyser = new VehicleDataAnalyser();
	vehicleDataAnalyser.setNorthBoundMap(Surveyor.northBoundMap);
	vehicleDataAnalyser.setSouthBoundMap(Surveyor.southBoundMap);
	vehicleDataAnalyser.setCountMapNorthBound(Surveyor.countMapNorthBound);
	vehicleDataAnalyser.setCountMapSouthBound(Surveyor.countMapSouthBound);
	vehicleDataAnalyser.setSortedMapNorthBound(Surveyor.northBoundSortedMap);
	vehicleDataAnalyser.setSortedMapSouthBound(Surveyor.southBoundSortedMap);
	
	}
	
}
