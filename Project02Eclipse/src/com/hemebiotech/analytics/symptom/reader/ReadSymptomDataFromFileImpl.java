package com.hemebiotech.analytics.symptom.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Read a symptom list from a file.
 * @author Mathias Lauer
 * 6 nov. 2020
 */
public class ReadSymptomDataFromFileImpl implements ISymptomReader {

	private String filepath;
	
	/**
	 * 
	 * @author Mathias Lauer
	 * 6 nov. 2020
	 * @param filepath a full or partial path to file with symptom strings in it, one per line.
	 */
	public ReadSymptomDataFromFileImpl (String filepath) {
		this.filepath = filepath;
	}
	
	/**
	 * Read a text file using NIO2.
	 * @author Mathias Lauer
	 * 6 nov. 2020
	 * @throws SymptomReaderException when filepath is null.
	 * @return List<String> a raw list of symptoms, duplicate are possible.
	 */
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
