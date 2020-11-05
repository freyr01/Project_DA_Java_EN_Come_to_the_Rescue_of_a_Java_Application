package com.hemebiotech.analytics.symptom.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Write symptoms and number of occurrence in a file as text.
 * @author Matt
 *
 */
public class WriteSymptomFileImpl implements ISymptomWriter{
	
	private final String outpath;
	private final Map<String, Integer> symptomMap;
	
	/**
	 * Constructor
	 * @param p_symptomMap map that contains symptoms as String and occurrences as Integer
	 * @param p_outpath Path as String to the file that will be write
	 * @throws SymptomWriteException when an argument is null
	 */
	public WriteSymptomFileImpl(final Map<String, Integer> p_symptomMap, final String p_outpath) 
								throws SymptomWriteException {
		
		this.outpath = p_outpath;
		this.symptomMap = p_symptomMap;
	}

	/**
	 * Browse the map and write each entries as 'symptom : occurrence' per line in the file given.
	 * @throws SymptomWriteException if something goes wrong with the write process
	 */
	@Override
	public void writeSymptoms() throws SymptomWriteException {
		
		BufferedWriter writer = null;
		
		try {
			
			writer = new BufferedWriter(new FileWriter(outpath));
			
			for(Map.Entry<String, Integer> entry : symptomMap.entrySet())
			{
				writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
			}
			
			writer.close();
			
		} catch (IOException e) {
			throw new SymptomWriteException(e.getMessage());
		}
	}
}
