package chapter10projectsFileIO;

import java.util.Random;
import java.util.Scanner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;

import java.lang.Character;

/**
 * Write a program to edit text files for extra blanks. The program will replace any
 * string of two or more blanks with a single blank. Your program should work as 
 * follows: Create a temporary file. Copy from the file to the temporary file but do not copy
 * extra blanks. Copy the contents of the temporary file back into the original 
 * file. Use a method (or Methods) in the class File to remove the temporary file.
 * You will also want to use the class File for other things in your program. The
 * temporary file should have a name that is different from all existing files so that
 * the existing files are not affected (except for the file being edited). Your program
 * will ask the user for the name of the file to be edited. However, it will not ask the 
 * user for the name of the temporary file but instead will generate the name within
 * the program. You can generate the name any way that is clear and efficient. One
 * possible way to generate the temporary file is to start with an unlikely name, such
 * as "TempX", and to append a character, such as 'X', until a name is found that does
 * not name an existing file. 
 *
 */

public class Project5 {
	
	public static void main(String args[])
	{
		//TODO
		//get filename from user
		String filename = "";
		Scanner keyboardScanner = new Scanner(System.in);
		BufferedReader fileReader = null; //Init to null, keep compiler happy. You cannot argue with the compiler.
		PrintWriter fileWriter = null; // same as above
		File outFile; //<-- No fucking clue what I'm supposed to do with this yet
		int temp;
		boolean blankPrevious = false; //initialize to false, obviously there's no character before the first

		try
		{
			System.out.println("Enter filename.");
			filename = keyboardScanner.nextLine();
			fileReader = new BufferedReader(new FileReader(filename)); //only using a BR you can read char by char.
			fileWriter = new PrintWriter(new FileOutputStream(generateSwapFileObject(filename)));//ripe for chaining pattern
			while((temp = fileReader.read()) >= 0)
			{
				if(Character.isWhitespace((char)temp) && !blankPrevious)
				{
					blankPrevious = true;
					System.out.print((char)temp);
				}
				if(!Character.isWhitespace((char)temp))
				{
					blankPrevious = false;
					System.out.print((char)temp);
				}
				
			}
			System.out.println();
			//close streams
			fileReader.close();
			fileWriter.close();
		}
		catch (FileNotFoundException fnfe)
		{
			System.out.println("file not found");
			System.out.println(fnfe.getMessage());
			System.exit(0);
		}
		catch (Exception e)
		{
			System.out.println("Generic exception caught in generic catch statement.");
			System.out.println(e.getMessage());
			System.exit(0);
		}
			
		//determine filename for swapfile
		//open input stream, open output stream
		//do the thing
		
	}
	
	private static File generateSwapFileObject(String originalFilename){
		File swapFileObject = null;
		Random random = new Random();
		do
		{
			swapFileObject = new File(originalFilename + ".swap" + random.nextInt(100));
		}
		while(swapFileObject.exists());
		//maybe return name?
		return swapFileObject;
	}
	
}
