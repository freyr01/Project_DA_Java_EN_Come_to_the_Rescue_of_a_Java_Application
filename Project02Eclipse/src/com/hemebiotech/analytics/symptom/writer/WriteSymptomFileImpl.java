package com.hemebiotech.analytics.symptom.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Implementation to write a file.
 * @author Mathias Lauer
 * 6 nov. 2020
 */
public class WriteSymptomFileImpl implements ISymptomWriter{
	
	private final String outpath;
	private final Map<String, Integer> symptomMap;
	
	/**
	 * Constructor
	 * @author Mathias Lauer
	 * 6 nov. 2020
	 * @param p_symptomMap map that contains symptoms as String and occurrences as Integer.
	 * @param p_outpath Path as String to the file that will be write.
	 */
	public WriteSymptomFileImpl(final Map<String, Integer> p_symptomMap, final String p_outpath)  {
		this.outpath = p_outpath;
		this.symptomMap = p_symptomMap;
	}

	/**
	 * Browse the map and write each entry as 'symptom: occurrence' one per line in the given file.
	 * @author Mathias Lauer
	 * 6 nov. 2020
	 * @throws SymptomWriteException if something goes wrong with the write process
	 */
	@Override
	public void writeSymptoms() throws SymptomWriteException {
		
		BufferedWriter writer = null;

		try {
			//Create buffer
			writer = new BufferedWriter(new FileWriter(outpath));
			//Browse each entry and write it in the buffer
			for(Map.Entry<String, Integer> entry : symptomMap.entrySet()) {
				writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
			}
			//Close the buffer
			writer.close();
		} 
		catch (IOException e) {
			throw new SymptomWriteException(e.getMessage());
		}
	}
}
