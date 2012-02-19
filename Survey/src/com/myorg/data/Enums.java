package com.myorg.data;

import com.myorg.data.Enums.TimeInDay;

public class Enums {

	public enum Day {
	    MONDAY, TUESDAY, WEDNESDAY,
	    THURSDAY, FRIDAY , SATURDAY; 
	    
	    int value(){
	        switch(this) {
	         case MONDAY: return 1;
	         case TUESDAY: return 2;
	         case WEDNESDAY: return 3;
	         case THURSDAY: return 4;
	         case FRIDAY: return 5;
	         
	         default: return 0;
	       }
	    }

	    public static Day forValue(int day) {
		    
			switch(day) {
			case 0 : return MONDAY;
	         case 1 :return TUESDAY;
	         case 2 : return  WEDNESDAY;
	         case 3 :return  THURSDAY;
	         case 4 : return FRIDAY;
	         
	        default: return SATURDAY;
	   
		}
	    }	
	}

public enum TimeInDay {
    AM,
    PM,
    M;

	public static TimeInDay forValue(int timeOfDay) {
	    
		switch(timeOfDay) {
        case 0 : return AM;
        case 1: return PM;
        
        default: return M;
   
	}
	}
    
}

}
