package com.myorg.utils;

import java.io.*;
import java.util.ArrayList;

public class FileRead 
{
   public static ArrayList<String> readFile(String fileName){
	   ArrayList<String> linesList = new ArrayList<String>();
	  try
	   {
		   
		// Open the file that is the first 
		// command line parameter
		FileInputStream fstream = new FileInputStream(fileName);
		// Get the object of DataInputStream
		DataInputStream in = new DataInputStream(fstream);
        	BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String strLine;
		
		//Read File Line By Line
		while ((strLine = br.readLine()) != null) 	{
			// Print the content on the console
			System.out.println (strLine);
			strLine.trim();
			linesList.add(strLine);
			
		}
		//Close the input stream
		in.close();
		}
   		catch (Exception e)
   		{//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
   		
   		return linesList;
}

	
}

