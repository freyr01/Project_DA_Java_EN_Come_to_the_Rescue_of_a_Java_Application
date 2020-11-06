package com.hemebiotech.analytics.symptom.writer;

/**
 * Signals that an error of some sort has occurred while writing data to somewhere
 * @author Mathias Lauer
 * 6 nov. 2020
 */
public class SymptomWriteException extends Exception {


		public SymptomWriteException()
		{
			super();
		}
		
		public SymptomWriteException(final String s)
		{
			super(s);
		}

}
