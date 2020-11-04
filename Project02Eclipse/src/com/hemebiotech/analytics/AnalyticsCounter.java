package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

import com.hemebiotech.analytics.symptom.counter.*;
import com.hemebiotech.analytics.symptom.reader.*;
import com.hemebiotech.analytics.symptom.sorter.*;
import com.hemebiotech.analytics.symptom.writer.*;

public class AnalyticsCounter {
	
	private static final String IN_FILE = "symptoms.txt";
	private static final String OUT_FILE = "result.out";
	
	public static void main(String args[]){

		ISymptomReader reader = null;
		ISymptomCounter counter = null;
		ISymptomWriter writer = null;
		ISymptomSorter sorter = null;
		List<String> rawSymptomList = null;
		Map<String, Integer> unsortedSymptomMap = null;
		Map<String, Integer> sortedSymptomMap = null;
		
		//Get input and count it
		try {
			reader = new ReadSymptomDataFromFileImpl(IN_FILE);
			rawSymptomList = reader.getSymptoms();

		} catch (SymptomReaderException e) {
			System.out.println("Read error: " + e.getMessage());
			return;
		}
		
		//Count the list
		counter = new CountSymptomFromList(rawSymptomList);
		unsortedSymptomMap = counter.countSymptoms();
		
		//Sort the map
		sorter = new SortSymptomFromListImpl(unsortedSymptomMap);
		sortedSymptomMap = sorter.sortSymptoms();

		
		//Write to a file
		try {
			writer = new WriteSymptomFileImpl(sortedSymptomMap, OUT_FILE);
			writer.writeSymptoms();
		} catch (SymptomWriteException e) {
			System.out.println("Write error: " + e.getMessage());
			return;
		}
		
	}
}
