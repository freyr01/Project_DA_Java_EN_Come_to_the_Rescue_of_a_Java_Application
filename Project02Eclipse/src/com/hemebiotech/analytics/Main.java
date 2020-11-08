package com.hemebiotech.analytics;

import com.hemebiotech.analytics.symptom.reader.SymptomReaderException;
import com.hemebiotech.analytics.symptom.writer.SymptomWriteException;
import com.hemebiotech.analytics.view.ConsoleView;
import com.hemebiotech.analytics.view.IViewable;

/**
 * Entry point of the application.
 * @author Mathias Lauer
 * 6 nov. 2020
 */
public class Main {
	
	public static void main(String args[]){
		
		IViewable view = new ConsoleView();
		
		try {
			AnalyticsController analyticsCounter = new AnalyticsController(view);
			analyticsCounter.writeSymptomsOccurrenceToFile();
		} catch (SymptomReaderException | SymptomWriteException e) {
			view.showError("Read/Write error: " +  e.getClass().getName() + "(" + e.getMessage() + ")");
		}
	}
}
