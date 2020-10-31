package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

import com.hemebiotech.analytics.SymptomCounter.ISymptomCounter;
import com.hemebiotech.analytics.SymptomCounter.SymptomCounterListImpl;
import com.hemebiotech.analytics.SymptomReader.ISymptomReader;
import com.hemebiotech.analytics.SymptomReader.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.SymptomWriter.ISymptomWriter;
import com.hemebiotech.analytics.SymptomWriter.SymptomWriteFileImpl;

public class AnalyticsCounter {
	
	public static void main(String args[]) throws Exception {
		// first get input
		ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
		List<String> rawSymptomList = reader.GetSymptoms();

		// Count the number of occurrence
		ISymptomCounter counter = new SymptomCounterListImpl(rawSymptomList);
		Map<String, Integer> occurenceNumber = counter.CountSymptoms();
		

		ISymptomWriter writer = new SymptomWriteFileImpl(occurenceNumber, "result.out");
		writer.WriteSymptoms();
	}
}
