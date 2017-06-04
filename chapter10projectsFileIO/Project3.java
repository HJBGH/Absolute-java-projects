package chapter10projectsFileIO;

import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.util.Scanner;

/**
 * Project description:
 * Write a program that takes its input from a text file of strings representing numbers of type double and outputs the average of the numbers in the file
 * to the screen. The file contains nothing but strings representing numbers of type double, one per line.
 *
 */
public class Project3 {
	
	private static final String FILENAME = "doubles.txt";
	
	public static void main(String args[])
	{
		double sum = 0;
		int count = 0;
		Scanner fileInputScanner = null;
		try
		{
			fileInputScanner = new Scanner(new FileInputStream(FILENAME));
		}
		catch(FileNotFoundException fnfe) //fnfe being an acronym for FileNotFoundException
		{
			System.out.println("Y'all fucked up, I can't find muh file");
			System.exit(0);
		}
		
		while(fileInputScanner.hasNextLine())
		{
			sum += fileInputScanner.nextDouble();
			count++;
			fileInputScanner.nextLine();
		}
		fileInputScanner.close();
		System.out.printf("Average: %f%n", sum/count);
	}
}
