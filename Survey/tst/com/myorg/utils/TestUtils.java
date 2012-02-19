package com.myorg.utils;

import java.util.Calendar;

import junit.framework.Assert;

import org.junit.Test;

public class TestUtils {

	 
	@Test
	public void testGetTimeOfDay(){
 
		Long timeInMillisec = new Long(268981);
			
		int utilValue = Util.getTimeOfDay(timeInMillisec);
		Assert.assertEquals(utilValue, Calendar.AM);
 
	}
	
}
