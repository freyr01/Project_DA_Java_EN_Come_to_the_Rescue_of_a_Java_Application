package com.hemebiotech.analytics;

import java.util.Scanner;

import com.hemebiotech.analytics.scanner.ConsoleImpl;
import com.hemebiotech.analytics.scanner.IScanner;
import com.hemebiotech.analytics.scanner.ScannerData;
import com.hemebiotech.analytics.symptom.reader.SymptomReaderException;
import com.hemebiotech.analytics.symptom.writer.SymptomWriteException;

/**
 * Entry point of the application
 * @author Matt
 *
 */
public class Main {
	
	public static void main(String args[]){
		
		IScanner scanner = new ConsoleImpl();
		ScannerData scannerData = scanner.getScannerData();
		
		try {
			AnalyticsCounter analyticsCounter = new AnalyticsCounter();
			analyticsCounter.writeSymptomsOccurrenceToFile(scannerData.getInputFile(), scannerData.getOutputFile());
		} catch (SymptomReaderException | SymptomWriteException e) {
			System.out.printf("Read/Write error: %s(%s)", e.getClass().getName(), e.getMessage());
		}
	}
}
