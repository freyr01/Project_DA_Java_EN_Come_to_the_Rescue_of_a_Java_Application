package com.hemebiotech.analytics.symptom.sorter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Sort symptoms Map<String, Integer> by alphabetic ascendant order.
 * @author Mathias Lauer
 * 6 nov. 2020
 */
public class SortSymptomFromListImpl implements ISymptomSorter{
	
	private final Map<String, Integer> unsortMap; 

	/**
	 * Constructor
	 * @author Mathias Lauer
	 * 6 nov. 2020
	 * @param Map<String, Integer> Unsorted map.
	 */
	public SortSymptomFromListImpl(final Map<String, Integer> p_unsortMap){
		unsortMap = p_unsortMap;
	}
	/**
	 * Using API Streams to sort the map
	 * @author Mathias Lauer
	 * 6 nov. 2020
	 * @return Map<String, Integer> Ordered map.
	 */
	@Override
	public Map<String, Integer> sortSymptoms() {
		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		sortedMap = unsortMap.entrySet()
				.stream() //Make a stream from the key set for advanced manipulation
				.sorted(Map.Entry.comparingByKey())
				//Comparator implementation returned by comparingByKey() to know how to sort data
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue,LinkedHashMap::new)); 
				//Collector implementation returned by the Collectors.toMap builder to know how and where put the data.
		return sortedMap;
	}

}
