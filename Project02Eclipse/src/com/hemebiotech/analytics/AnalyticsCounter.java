package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

import com.hemebiotech.analytics.symptom.counter.ISymptomCounter;
import com.hemebiotech.analytics.symptom.counter.CountSymptomFromList;
import com.hemebiotech.analytics.symptom.reader.ISymptomReader;
import com.hemebiotech.analytics.symptom.reader.ReadSymptomDataFromFileImpl;
import com.hemebiotech.analytics.symptom.writer.ISymptomWriter;
import com.hemebiotech.analytics.symptom.writer.WriteSymptomFileImpl;

public class AnalyticsCounter {
	
	public static void main(String args[]) throws Exception {
		// first get input
		ISymptomReader reader = new ReadSymptomDataFromFileImpl("symptoms.txt");
		List<String> rawSymptomList = reader.GetSymptoms();

		// Count the number of occurrence
		ISymptomCounter counter = new CountSymptomFromList(rawSymptomList);
		Map<String, Integer> occurenceNumber = counter.CountSymptoms();
		

		ISymptomWriter writer = new WriteSymptomFileImpl(occurenceNumber, "result.out");
		writer.WriteSymptoms();
	}
}
