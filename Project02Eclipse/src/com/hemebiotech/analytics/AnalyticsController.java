package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

import com.hemebiotech.analytics.symptom.counter.*;
import com.hemebiotech.analytics.symptom.reader.*;
import com.hemebiotech.analytics.symptom.sorter.*;
import com.hemebiotech.analytics.symptom.writer.*;
import com.hemebiotech.analytics.view.IViewable;

/**
 * Contain all the methods can be used to process the symptoms list.
 * @author Mathias Lauer
 * 6 nov. 2020
 */
public class AnalyticsController {
	
	private IViewable view;
	
	/**
	 * Constructor
	 * @author Mathias Lauer
	 * 8 nov. 2020
	 * @param p_view A View that implement IViewable interface.
	 */
	public AnalyticsController(IViewable p_view) {
		this.view = p_view;
	}
	
	/**
	 * Read a symptoms file, count the number of symptoms then sort it, finally write the result in a file.
	 * @author Mathias Lauer
	 * 6 nov. 2020
	 * @throws SymptomReaderException when something goes wrong while reading the source file.
	 * @throws SymptomWriteException when something goes wrong while writing the destination file.
	 */
	public void writeSymptomsOccurrenceToFile() 
			throws SymptomReaderException, SymptomWriteException {
		//Read from file
		ISymptomReader reader = new ReadSymptomDataFromFileImpl(view.getInputFile());
		List<String> rawSymptomList = reader.getSymptoms();

		//Count the list
		ISymptomCounter counter = new CountSymptomFromListImpl(rawSymptomList);
		Map<String, Integer> unsortedSymptomMap = counter.countSymptoms();
		
		//Sort the map
		ISymptomSorter sorter = new SortSymptomFromListImpl(unsortedSymptomMap);
		Map<String, Integer> sortedSymptomMap = sorter.sortSymptoms();
		
		//Write to file
		ISymptomWriter writer = new WriteSymptomFileImpl(sortedSymptomMap, view.getOutputFile());
		writer.writeSymptoms();		
	}
}
