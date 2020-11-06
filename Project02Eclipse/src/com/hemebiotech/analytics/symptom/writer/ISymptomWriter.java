package com.hemebiotech.analytics.symptom.writer;
/**
 * Anything that can write symptoms data to somewhere.
 * @author Mathias Lauer
 * 6 nov. 2020
 */
public interface ISymptomWriter {
	
	/**
	 * Write process implementation
	 * @author Mathias Lauer
	 * 6 nov. 2020
	 * @throws SymptomWriteException When something goes wrong with the write process.
	 */
	public void writeSymptoms() throws SymptomWriteException;

}
