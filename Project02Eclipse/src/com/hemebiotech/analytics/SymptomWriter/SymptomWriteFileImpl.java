package com.hemebiotech.analytics.SymptomWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Write symptoms and number of occurrence in a file as text.
 * @author Matt
 *
 */
public class SymptomWriteFileImpl implements ISymptomWriter{
	
	private final String outpath;
	private final Map<String, Integer> symptomMap;
	
	/**
	 * Constructor
	 * @param Map<String, Integer> that contains symptoms and occurrences
	 * @param Path as String to the file that will be write
	 * @throws SymptomWriteException when an argument is null
	 */
	public SymptomWriteFileImpl(final Map<String, Integer> p_symptomMap,
								final String p_outpath) 
								throws SymptomWriteException {
		
		if(p_outpath == null || p_symptomMap == null) 
			throw new SymptomWriteException("null argument not permitted");
		
		this.outpath = p_outpath;
		this.symptomMap = p_symptomMap;
	}

	/**
	 * Browse the map and write each entries as 'symptom : occurrence' per line in the file given.
	 * @throws SymptomWriteException if something goes wrong with the write process
	 */
	@Override
	public void WriteSymptoms() throws SymptomWriteException {
		
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
