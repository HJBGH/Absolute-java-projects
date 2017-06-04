package chapter10projectsFileIO;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileInputStream;

/**
 * You have a text file named marks.txt that stores the marks obtained by the students of a particular grade.
 * It is a text file of strings representing numbers of type int and each line stores one number. Write a program that will read the
 * file and display the highest and lowers marks on screen.
 *
 */
public class Project2 {
	private static final String FILENAME = "marks.txt";
	public static void main(String args[]){
		Scanner inputStreamScanner = null;
		try
		{
			inputStreamScanner = new Scanner(new FileInputStream("marks.txt"));
		}
		catch (FileNotFoundException fnfe) //fnfe being an acronym for FileNotFoundException
		{
			System.out.println("I can't find the file idiot.");
			System.exit(1);
		}
		//we assume that the file is well formed, IE; matches the description given by the project outline. This isn't good practise but I've got like 12 of these to do.
		inputStreamScanner.close();
	}
}
