package com.hemebiotech.analytics;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.hemebiotech.analytics.symptom.counter.*;
import com.hemebiotech.analytics.symptom.reader.*;
import com.hemebiotech.analytics.symptom.sorter.*;
import com.hemebiotech.analytics.symptom.writer.*;

public class AnalyticsCounter {
	
	private static final String DEF_IN_FILE = "symptoms.txt";
	private static final String DEF_OUT_FILE = "result.out";
	
	public static void main(String args[]){

		ISymptomReader reader = null;
		ISymptomCounter counter = null;
		ISymptomWriter writer = null;
		ISymptomSorter sorter = null;
		List<String> rawSymptomList = null;
		Map<String, Integer> unsortedSymptomMap = null;
		Map<String, Integer> sortedSymptomMap = null;
		String inFile = DEF_IN_FILE;
		String outFile = DEF_OUT_FILE;
		
		//Get filenames from the user
		try (Scanner scanner = new Scanner(System.in)){
			System.out.printf("Symptoms source file, default [%s]: ", inFile);
			inFile = scanner.nextLine();
			if(inFile.isEmpty()) inFile = DEF_IN_FILE;
			System.out.printf("Write results in, default [%s]: ", outFile);
			outFile = scanner.nextLine();
			if(outFile.isEmpty()) outFile = DEF_OUT_FILE;
		}
		
		//Get input and count it
		try {
			reader = new ReadSymptomDataFromFileImpl(inFile);
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
			writer = new WriteSymptomFileImpl(sortedSymptomMap, outFile);
			writer.writeSymptoms();
		} catch (SymptomWriteException e) {
			System.out.println("Write error: " + e.getMessage());
			return;
		}
		
	}
	
}
