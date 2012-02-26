package com.myorg.core;

import junit.framework.Assert;

import org.junit.Test;

public class TestSurveyor {
	
	 
	/*@Test
	public void testCountForNorthBound() {
 
		Surveyor surveyor = new Surveyor();
		surveyor.create();
		Assert.assertEquals(surveyor.getCountForNorthBound() , 2);
 
	}
*/
/*	@Test
	public void testgetCountOfcarsInMorning() {
 
		Surveyor surveyor = new Surveyor();
		surveyor.create();
		
		Assert.assertEquals(surveyor.getCountOfcarsInMorning(), 3);
 
	}
*/
	/*@Test
	public void testgetCountOfCarsInTimeSpansofEveryHour(){
		
		Surveyor.create();
		
		Surveyor.getCountOfCarsInTimeSpansofEveryFifteenMinutesNorthBound(); 
	}*/
	
	@Test
	public void testgetgetCountOfCarsInTimeSpansofEveryHour(){
		
		Surveyor.create();
		
		Surveyor.getAverageCountOfCarsInTimeSpansofEveryFifteenMinutesNorthBound();
		
		Surveyor.getPeakVolumeTimesNorthBound();
		
	}
	
	@Test
	public void testgetgetCountOfCarsInTimeSpansofEveryHourSouthBound(){
		
		Surveyor.create();
		
		Surveyor.getAverageCountOfCarsInTimeSpansofEveryFifteenMinutesSouthBound();
		
		Surveyor.getPeakVolumeTimesSouthBound();
		
	}
	
}
