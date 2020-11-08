package com.hemebiotech.analytics.symptom.sorter;

import java.util.Map;

/**
 * Anything that can sort a Map.
 * @author Mathias Lauer
 * 6 nov. 2020
 */
public interface ISymptomSorter {
	/**
	 * Used to sort a Map.
	 * @author Mathias Lauer
	 * 6 nov. 2020
	 * @return Map containing sorted symptoms with them occurrences.
	 */
	Map<String, Integer> sortSymptoms();

}
