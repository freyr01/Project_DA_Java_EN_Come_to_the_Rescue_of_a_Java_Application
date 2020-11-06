package com.hemebiotech.analytics.symptom.reader;

import java.util.List;

/**
 * Anything that will read symptom data from a source.
 * The important part is, the return value from the operation, which is a list of strings,
 * that may contain many duplications.
 * 
 * The implementation does not need to order the list.
 * @author Mathias Lauer
 * 6 nov. 2020
 */
public interface ISymptomReader {
	/**
	 * If no data is available, return an empty List.
	 * @author Mathias Lauer
	 * 6 nov. 2020
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable.
	 * @throws SymptomReaderException when something goes wrong with the reader.
	 */
	List<String> getSymptoms () throws SymptomReaderException;
}
