package com.hemebiotech.analytics.symptom.counter;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Count the number of symptom string in a list
 * @author Matt
 *
 */
public class CountSymptomFromList implements ISymptomCounter {
	
	private final List<String> symptomList;
	
	public CountSymptomFromList(final List<String> p_symptomList) throws SymptomCounterException {
		if(p_symptomList == null) throw new SymptomCounterException("Argument cannot be null");
		this.symptomList = p_symptomList;
	}

	/**
	 * Browse the list and increment the occurence's number of a particular symptom
	 * @return A map where key is a symptom and value is the number of occurrence
	 */
	@Override
	public Map<String, Integer> countSymptoms() throws SymptomCounterException {
		Map<String, Integer> symptomMap = new Hashtable<String, Integer>();

		for(final String symptom : symptomList)
		{
			if(symptomMap.containsKey(symptom)) // if the symptom was already seen
			{
				int nbr = symptomMap.get(symptom); //Get the number of occurrence
				nbr++;								//Increment it
				symptomMap.replace(symptom, nbr);  //Update the map with the new value
			}
			else
			{
				symptomMap.put(symptom, 1);			//Else put a new symptom in the map with one occurrence
			}
		}
		
		return symptomMap;
	}

}
