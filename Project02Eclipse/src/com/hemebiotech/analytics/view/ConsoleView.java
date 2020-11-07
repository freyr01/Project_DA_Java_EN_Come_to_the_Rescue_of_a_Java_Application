package com.hemebiotech.analytics.view;

import java.util.Scanner;

/**
 * This implementation represent a terminal view
 * @author Mathias Lauer
 * 6 nov. 2020
 */
public class ConsoleView implements IViewable {
	private final String DEFAULT_SRC = "symptoms.txt";
	private final String DEFAULT_DEST = "result.out";
	private Scanner scanner = new Scanner(System.in);
	
	/**
	 * Use a scanner to ask the path of the symptom file
	 * @author Mathias Lauer
	 * 7 nov. 2020
	 * @return {@inheritDoc}
	 */
	@Override
	public String askInputFile() {
		String inputFile;
		System.out.printf("Symptoms source file, default [%s]: ", DEFAULT_SRC);
		inputFile = scanner.nextLine();
		if(inputFile.isEmpty()) inputFile = DEFAULT_SRC;	

		return inputFile;
	}
	
	/**
	 * Use a scanner to ask the path of the file will contain the results
	 * @author Mathias Lauer
	 * 7 nov. 2020
	 * @return {@inheritDoc}
	 */
	@Override
	public String askOutputFile() {
		String outputFile;
		System.out.printf("File to write, default [%s]: ", DEFAULT_DEST);
		outputFile = scanner.nextLine();
		if(outputFile.isEmpty()) outputFile = DEFAULT_DEST;	

		return outputFile;
		
	}

}
