package test;

import java.util.Scanner;

public class Chapter2Exercise14 {
	public static void main(String args[]){
		Scanner inputObj = new Scanner(System.in);
		String firstStr = inputObj.next();
		String secondStr = inputObj.next();
		String thirdStr = inputObj.next();
		inputObj.nextLine();
		System.out.printf("%s %s %s", firstStr, secondStr, thirdStr);
	}
}
