package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.List;

import com.hemebiotech.analytics.SymptomCounter.ISymptomCounter;
import com.hemebiotech.analytics.SymptomCounter.SymptomCounterListImpl;
import com.hemebiotech.analytics.SymptomReader.ISymptomReader;
import com.hemebiotech.analytics.SymptomReader.ReadSymptomDataFromFile;

public class AnalyticsCounter {
	
	public static void main(String args[]) throws Exception {
		// first get input
		ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
		List<String> rawSymptomList = reader.GetSymptoms();

		ISymptomCounter counter = new SymptomCounterListImpl(rawSymptomList);
		System.out.println(counter.CountSymptoms());
		

		// next generate output
		/*
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + dialatedPupilCount + "\n");
		writer.close();
		*/
	}
}
