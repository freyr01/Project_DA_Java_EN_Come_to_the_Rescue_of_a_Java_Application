package com.hemebiotech.analytics.SymptomReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Read a symptom list from a file
 * 
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 * @throws SymptomReaderException when filepath is null
	 */
	public ReadSymptomDataFromFile (String filepath) throws SymptomReaderException {
		if(filepath == null) throw new SymptomReaderException("filepath cannot be null");
		this.filepath = filepath;
	}
	
	@Override
	public List<String> GetSymptoms() throws SymptomReaderException {
		List<String> result = null;

		try {
			result = Files.readAllLines(Path.of(filepath));
		} catch (IOException e) {
			throw new SymptomReaderException(e.getMessage());
		}
		
		
		return result;
	}

}
