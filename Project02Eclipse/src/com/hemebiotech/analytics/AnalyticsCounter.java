package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

import com.hemebiotech.analytics.symptom.counter.*;
import com.hemebiotech.analytics.symptom.reader.*;
import com.hemebiotech.analytics.symptom.sorter.*;
import com.hemebiotech.analytics.symptom.writer.*;

/**
 * This class provide static methods to manipulate list of symptoms
 * @author Matt
 *
 */
public class AnalyticsCounter {
	
	/**
	 * This method take symptom file, do a count and a sort treatment and write the result
	 * @param inFile Symptoms file with strings in it, one per line
	 * @param outFile File to write the result
	 * @throws SymptomReaderException 
	 * @throws SymptomWriteException 
	 */
	public void writeSymptomsOccurrenceToFile(final String inFile, final String outFile) 
			throws SymptomReaderException, SymptomWriteException
	{
		//Get input and count it
		ISymptomReader reader = new ReadSymptomDataFromFileImpl(inFile);
		List<String> rawSymptomList = reader.getSymptoms();

		//Count the list
		ISymptomCounter counter = new CountSymptomFromList(rawSymptomList);
		Map<String, Integer> unsortedSymptomMap = counter.countSymptoms();
		
		//Sort the map
		ISymptomSorter sorter = new SortSymptomFromListImpl(unsortedSymptomMap);
		Map<String, Integer> sortedSymptomMap = sorter.sortSymptoms();
		
		//Write to a file
		ISymptomWriter writer = new WriteSymptomFileImpl(sortedSymptomMap, outFile);
		writer.writeSymptoms();

				
	}
}
