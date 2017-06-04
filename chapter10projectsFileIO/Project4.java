package chapter10projectsFileIO;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileInputStream;

/**
 * You have collected yearly rainfall data for a few years in your locality 
 * for an irrigation design project. It is stored in a text file named rainfall.txt 
 * that stores the yearly rainfall data as strings representing numbers of type
 * double indication rainfall in mm for each year. Write a program that outputs 
 * the average rainfall (mm) for the data collected. It should display a bar
 * chart displaying a star (*) for every 100 mm of rainfall
 *
 */
//this project is dull as shit, you'd think they'd specify specific years to go with it or something
public class Project4 {

	private static final String FILENAME = "rainfall.txt";
	
	public static void main(String args[])
	{
		int lineCount = 0;
		Scanner fileStreamScanner = null;
		
		try
		{
			fileStreamScanner = new Scanner(new FileInputStream(FILENAME));
		}
		catch(FileNotFoundException fnfe)
		{
			System.out.println("I CAN'T FIND MUH FILE!");
			System.exit(0);
		}
		//the other shite
	}
	
	
}
