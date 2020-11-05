package com.hemebiotech.analytics;

import java.util.Scanner;

import com.hemebiotech.analytics.symptom.reader.SymptomReaderException;
import com.hemebiotech.analytics.symptom.writer.SymptomWriteException;

/**
 * Entry point of the application
 * @author Matt
 *
 */
public class Main {
	private static String inFile = "symptoms.txt";
	private static String outFile = "result.out";
	
	public static void main(String args[]){
		
		//Get filenames from the user
		try (Scanner scanner = new Scanner(System.in)){
			String input;
			System.out.printf("Symptoms source file, default [%s]: ", inFile);
			input = scanner.nextLine();
			if( ! input.isEmpty()) inFile = input;
			System.out.printf("Write results in, default [%s]: ", outFile);
			input = scanner.nextLine();
			if( ! input.isEmpty()) outFile = input;
		}
		
		try {
			AnalyticsCounter.writeSymptomsOccurrenceToFile(inFile, outFile);
		} catch (SymptomReaderException | SymptomWriteException e) {
			System.out.printf("Read/Write error: %s(%s)", e.getClass().getName(), e.getMessage());
		}
	}
}
