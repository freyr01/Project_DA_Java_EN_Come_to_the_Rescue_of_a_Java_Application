package com.hemebiotech.analytics.symptom.sorter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Sort symptoms Map by alphabetic ascendant order.
 * @author Mathias Lauer
 * 6 nov. 2020
 */
public class SortSymptomFromListImpl implements ISymptomSorter{
	
	private final Map<String, Integer> unsortedMap; 

	/**
	 * Constructor
	 * @author Mathias Lauer
	 * 6 nov. 2020
	 * @param p_unsortedMap Unsorted Map.
	 */
	public SortSymptomFromListImpl(final Map<String, Integer> p_unsortedMap){
		unsortedMap = p_unsortedMap;
	}
	/**
	 * Using API Streams to sort the map
	 * @author Mathias Lauer
	 * 6 nov. 2020
	 * @return Ordered Map.
	 */
	@Override
	public Map<String, Integer> sortSymptoms() {
		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		sortedMap = unsortedMap.entrySet()
				.stream() //Make a stream from the key set for advanced manipulation
				.sorted(Map.Entry.comparingByKey())
				//Comparator returned by comparingByKey() to know how to sort data
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, 
											(oldValue, newValue) -> oldValue,
											LinkedHashMap::new)); 
				//Collector returned by the Collectors.toMap builder to know how and where put the data.
		return sortedMap;
	}

}
