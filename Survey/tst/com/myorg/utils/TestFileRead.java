package com.myorg.utils;


import java.util.ArrayList;
import junit.framework.Assert;

import org.junit.Test;

public class TestFileRead {

	
		@Test
		public void testFileRead(){
	 
			ArrayList<String> linesList = FileRead.readFile("D:\\Swaroop\\NOKIA\\WORKSPACE\\OMA\\Survey\\resources\\vehicleData.txt");
			
			Assert.assertEquals(linesList.size(),10);
	 
		}
		
	}
