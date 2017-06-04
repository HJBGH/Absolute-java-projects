package chapter10projectsFileIO;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileInputStream;

/**
 * You have a text file named marks.txt that stores the marks obtained by the students of a particular grade.
 * It is a text file of strings representing numbers of type int and each line stores one number. Write a program that will read the
 * file and display the highest and lowest marks on screen.
 *
 */
public class Project2 {
	
	private static final String FILENAME = "marks.txt";
	private static final int HIGHEST_POSSIBLE_GRADE = 100;
	private static final int LOWEST_POSSIBLE_GRADE = 0;
	
	public static void main(String args[]){
		int highest = LOWEST_POSSIBLE_GRADE;
		int lowest = HIGHEST_POSSIBLE_GRADE;
		int temp = -1; //Holding variable for read loop
		Scanner inputStreamScanner = null;
		try
		{
			inputStreamScanner = new Scanner(new FileInputStream(FILENAME));
		}
		catch (FileNotFoundException fnfe) //fnfe being an acronym for FileNotFoundException
		{
			System.out.println("I can't find the file idiot.");
			System.exit(1);
		}
		//we assume that the file is well formed, IE; matches the description given by the project outline. This isn't good practise but I've got like 12 of these to do.
		while (inputStreamScanner.hasNextLine())
		{
			temp = inputStreamScanner.nextInt();
			if(temp > highest)
				highest=temp;
			if(temp<lowest)
				lowest=temp;
		}
		System.out.printf("Lowest: %d%nHighest: %d%n", lowest, highest);
	}
}
