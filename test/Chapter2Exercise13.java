package test;

import java.util.Scanner;

public class Chapter2Exercise13 {
	public static void main(String args[]){
		Scanner inputObj = new Scanner(System.in);
		double x = inputObj.nextDouble();
		double y = inputObj.nextDouble();
		inputObj.nextLine();
		System.out.printf("%f + %f = %f", x, y, x+y);
	}
}
