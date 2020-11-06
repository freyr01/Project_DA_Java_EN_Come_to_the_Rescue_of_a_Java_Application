package com.hemebiotech.analytics.symptom.counter;

import java.util.Map;

/**
 * Anything that can count a list of things in an array.
 * @author Mathias Lauer
 * 6 nov. 2020
 */
public interface ISymptomCounter {
	/**
	 * Count process implementation
	 * @author Mathias Lauer
	 * 6 nov. 2020
	 * @return A map where key=symptom and value=the number of occurrence.
	 */
	Map<String, Integer> countSymptoms();

}
