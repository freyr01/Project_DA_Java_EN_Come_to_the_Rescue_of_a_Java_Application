package com.hemebiotech.analytics.symptom.sorter;

import java.util.Map;

/**
 * Anything that can sort a Map<String, Integer>.
 * @author Mathias Lauer
 * 6 nov. 2020
 */
public interface ISymptomSorter {
	/**
	 * Used to sort a Map<String, Integer>.
	 * @author Mathias Lauer
	 * 6 nov. 2020
	 */
	Map<String, Integer> sortSymptoms();

}
