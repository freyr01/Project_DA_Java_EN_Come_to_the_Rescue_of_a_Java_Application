package com.hemebiotech.analytics.SymptomWriter;

/**
 * Signals that an error of some sort has occurred while writing data to somewhere
 * @author Matt
 *
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
