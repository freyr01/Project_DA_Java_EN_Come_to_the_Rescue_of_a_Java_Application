package com.hemebiotech.analytics.symptom.counter;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Count the number of symptom string in a list.
 * @author Mathias Lauer
 * 6 nov. 2020
 */
public class CountSymptomFromListImpl implements ISymptomCounter {
	
	private final List<String> symptomList;
	
	/**
	 * Constructor
	 * @author Mathias Lauer
	 * 8 nov. 2020
	 * @param p_symptomList A raw List of symptoms
	 */
	public CountSymptomFromListImpl(final List<String> p_symptomList) {
		this.symptomList = p_symptomList;
	}

	/**
	 * Browse the list and put any new symptom in the map with one occurrence,
	 * or increment occurrence value if symptom is already in
	 * @author Mathias Lauer
	 * 6 nov. 2020
	 * @return A map where key is a symptom and value is the number of occurrence.
	 */
	@Override
	public Map<String, Integer> countSymptoms() {
		Map<String, Integer> symptomMap = new Hashtable<String, Integer>();

		for(final String symptom : symptomList)
		{
			if( ! symptomMap.containsKey(symptom)) { // if the symptom is not present in the map.
				symptomMap.put(symptom, 1);			//Put it in with one occurrence.
			}
			else {									//Else
				int occurrences = symptomMap.get(symptom); //Get the number of occurrence
				occurrences++;								//Increment it
				symptomMap.replace(symptom, occurrences);  //Update the map with the new value
			}
		}
		
		return symptomMap;
	}

}
