package com.hemebiotech.analytics.SymptomWriter;
/**
 *  * Anything that will write symptoms data to somewhere
 * @author Matt
 *
 */
public interface ISymptomWriter {
	
	public void WriteSymptoms() throws SymptomWriteException;

}
