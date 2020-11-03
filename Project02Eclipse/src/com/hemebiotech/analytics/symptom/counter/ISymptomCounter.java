package com.hemebiotech.analytics.symptom.counter;

import java.util.Map;

/**
 * Anything that can count a list of things in an array
 * @author Matt
 *
 */
public interface ISymptomCounter {
	/**
	 * 
	 * @return A map representing each things as a String with them number of occurrence
	 * @throws SymptomCounterException when something goes wrong with the counter
	 */
	Map<String, Integer> countSymptoms() throws SymptomCounterException;

}
