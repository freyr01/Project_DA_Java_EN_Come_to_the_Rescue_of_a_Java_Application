package com.hemebiotech.analytics;

import com.hemebiotech.analytics.symptom.reader.SymptomReaderException;
import com.hemebiotech.analytics.symptom.writer.SymptomWriteException;
import com.hemebiotech.analytics.view.ConsoleView;

/**
 * Entry point of the application.
 * @author Mathias Lauer
 * 6 nov. 2020
 */
public class Main {
	
	public static void main(String args[]){
		
		try {
			AnalyticsCounter analyticsCounter = new AnalyticsCounter();
			analyticsCounter.writeSymptomsOccurrenceToFile(new ConsoleView());
		} catch (SymptomReaderException | SymptomWriteException e) {
			System.out.printf("Read/Write error: %s(%s)", e.getClass().getName(), e.getMessage());
		}
	}
}
