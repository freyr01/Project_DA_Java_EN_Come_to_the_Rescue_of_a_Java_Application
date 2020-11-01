package com.hemebiotech.analytics.symptom.sorter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortSymptomFromListImpl implements ISymptomSort{
	
	private final Map<String, Integer> unsortMap; 

	public SortSymptomFromListImpl(final Map<String, Integer> p_unsortMap) throws SymptomSortException {
		if(p_unsortMap == null) throw new SymptomSortException("null argument not permitted");
		unsortMap = p_unsortMap;
	}
	@Override
	public Map<String, Integer> SortSymptoms() throws SymptomSortException {
		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		sortedMap = unsortMap.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByKey()) //Comparator by key method 
				.collect(Collectors.toMap			
					(
						Map.Entry::getKey, Map.Entry::getValue
						, (oldValue, newValue) -> oldValue
						, LinkedHashMap::new)			
					);
		return sortedMap;
	}

}
