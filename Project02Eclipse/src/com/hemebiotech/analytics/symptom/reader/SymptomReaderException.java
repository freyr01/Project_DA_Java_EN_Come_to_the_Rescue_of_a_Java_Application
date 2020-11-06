package com.hemebiotech.analytics.symptom.reader;

/**
 * Signals that an error of some sort has occurred while reading a Symptom data source.
 * @author Mathias Lauer
 * 6 nov. 2020
 */
public class SymptomReaderException extends Exception {
	
	public SymptomReaderException()
	{
		super();
	}
	
	public SymptomReaderException(final String s)
	{
		super(s);
	}

}
