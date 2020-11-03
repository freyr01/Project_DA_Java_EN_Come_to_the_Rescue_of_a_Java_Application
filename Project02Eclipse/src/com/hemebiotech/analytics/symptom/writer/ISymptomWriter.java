package com.hemebiotech.analytics.symptom.writer;
/**
 * Anything that will write symptoms data to somewhere
 * @author Matt
 *
 */
public interface ISymptomWriter {
	
	public void writeSymptoms() throws SymptomWriteException;

}
