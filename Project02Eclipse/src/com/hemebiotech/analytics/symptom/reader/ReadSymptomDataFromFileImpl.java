package com.hemebiotech.analytics.symptom.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Read a symptom list from a file
 * 
 */
public class ReadSymptomDataFromFileImpl implements ISymptomReader {

	private String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 * @throws SymptomReaderException when filepath is null
	 */
	public ReadSymptomDataFromFileImpl (String filepath) {
		this.filepath = filepath;
	}
	
	@Override
	public List<String> getSymptoms() throws SymptomReaderException {
		List<String> result = null;

		try {
			result = Files.readAllLines(Path.of(filepath));
		} catch (IOException e) {
			throw new SymptomReaderException(e.getMessage());
		}
		
		
		return result;
	}

}
