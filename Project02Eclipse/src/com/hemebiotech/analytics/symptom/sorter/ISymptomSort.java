package com.hemebiotech.analytics.symptom.sorter;

import java.util.Map;

public interface ISymptomSort {
	
	Map<String, Integer> sortSymptoms() throws SymptomSortException;

}
