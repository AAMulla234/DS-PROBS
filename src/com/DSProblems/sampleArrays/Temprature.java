package com.DSProblems.sampleArrays;

import java.util.Scanner;

public class Temprature {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner console = new Scanner(System.in);
		System.out.println("How many days's temprature?");
		int numDays = console.nextInt();
		int sum = 0;
		int tempArray[] = new int[numDays];
		for(int i=1; i <= numDays; i++) {
			System.out.println("Day" + i + "'s high temp:");
			tempArray[i-1] = console.nextInt();
			sum += tempArray[i-1];
		}
		
		double average = sum/ numDays;
		int above = 0;
		for (int i=0; i < numDays; i++) {
			if(tempArray[i] > average) 
				above++;
		}
		System.out.println("Average Temp: " + average + " No of days above:" + above);
		
		// Find temp below Average
		int minAvg = tempArray[0];
		for(int i=1; i< numDays; i++) {
			if (minAvg < average && tempArray[i] < minAvg)
				minAvg = tempArray[i];
		}
		System.out.println("Temprature minimum is::" + minAvg);
	}

	
	
}
