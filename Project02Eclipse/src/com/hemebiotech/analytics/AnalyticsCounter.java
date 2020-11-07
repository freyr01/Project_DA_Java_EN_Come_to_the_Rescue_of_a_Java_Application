package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

import com.hemebiotech.analytics.symptom.counter.*;
import com.hemebiotech.analytics.symptom.reader.*;
import com.hemebiotech.analytics.symptom.sorter.*;
import com.hemebiotech.analytics.symptom.writer.*;
import com.hemebiotech.analytics.view.ConsoleView;
import com.hemebiotech.analytics.view.IViewable;

/**
 * Contain all the methods can be used to process the symptoms list.
 * @author Mathias Lauer
 * 6 nov. 2020
 */
public class AnalyticsCounter {
	
	/**
	 * This method take symptom file, do a count and a sort treatment and write the result
	 * @author Mathias Lauer
	 * 6 nov. 2020
	 * @param inFile Symptoms file with strings in it, one per line.
	 * @param outFile File where write the result.
	 * @throws SymptomReaderException when something goes wrong while reading the source file.
	 * @throws SymptomWriteException when something goes wrong while writing the destination file.
	 */
	public void writeSymptomsOccurrenceToFile(IViewable view) 
			throws SymptomReaderException, SymptomWriteException
	{
		//Get source file
		String inputFile = view.askInputFile();
		
		ISymptomReader reader = new ReadSymptomDataFromFileImpl(inputFile);
		List<String> rawSymptomList = reader.getSymptoms();

		//Count the list
		ISymptomCounter counter = new CountSymptomFromList(rawSymptomList);
		Map<String, Integer> unsortedSymptomMap = counter.countSymptoms();
		
		//Sort the map
		ISymptomSorter sorter = new SortSymptomFromListImpl(unsortedSymptomMap);
		Map<String, Integer> sortedSymptomMap = sorter.sortSymptoms();
		
		//Write
		ISymptomWriter writer = new WriteSymptomFileImpl(sortedSymptomMap, view.askOutputFile());
		writer.writeSymptoms();

				
	}
}
