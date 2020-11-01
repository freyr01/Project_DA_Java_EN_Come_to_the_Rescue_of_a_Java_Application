package com.hemebiotech.analytics.symptom.counter;

/**
 * Signals that an error of some sort has occurred while counting a list of things
 * @author Matt
 *
 */
public class SymptomCounterException extends Exception {
	
	public SymptomCounterException()
	{
		super();
	}
	
	public SymptomCounterException(final String s)
	{
		super(s);
	}

}
