package com.hemebiotech.analytics.symptom.sorter;
/**
 * Signals that an error of some sort has occurred while sorting a Symptom data source
 * @author Matt
 *
 */
public class SymptomSortException extends Exception {
	
	public SymptomSortException()
	{
		super();
	}
	
	public SymptomSortException(final String s)
	{
		super(s);
	}

}