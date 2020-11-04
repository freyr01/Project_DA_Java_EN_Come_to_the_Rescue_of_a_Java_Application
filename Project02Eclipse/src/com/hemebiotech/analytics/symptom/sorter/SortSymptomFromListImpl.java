package com.hemebiotech.analytics.symptom.sorter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortSymptomFromListImpl implements ISymptomSorter{
	
	private final Map<String, Integer> unsortMap; 

	public SortSymptomFromListImpl(final Map<String, Integer> p_unsortMap){
		unsortMap = p_unsortMap;
	}
	@Override
	public Map<String, Integer> sortSymptoms() {
		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		sortedMap = unsortMap.entrySet()
				.stream() //Make a stream from the key set for advanced manipulation
				.sorted(Map.Entry.comparingByKey())
				//sorted need a Comparator implementation returned by comparingByKey() to know how to sort data
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)); 
				//collect need a Collector implementation returned by the Collectors.toMap builder to make a new map based on data of the stream.
		return sortedMap;
	}

}
