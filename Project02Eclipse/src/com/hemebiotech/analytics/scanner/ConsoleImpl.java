package com.hemebiotech.analytics.scanner;

import java.util.Scanner;

/**
 * This implementation handle user input in terminal.
 * @author Mathias Lauer
 * 6 nov. 2020
 */
public class ConsoleImpl implements IScanner {
	private String inFile = "symptoms.txt";
	private String outFile = "result.out";
	
	/**
	 * Ask user source file and file to write, a scanner will get the input.
	 * @author Mathias Lauer
	 * 6 nov. 2020
	 * @return ScannerData Databean containing parameters entered by user.
	 */
	@Override
	public ScannerData getScannerData() {
		try (Scanner scanner = new Scanner(System.in)){
			
			String input;
			
			System.out.printf("Symptoms source file, default [%s]: ", inFile);
			input = scanner.nextLine();
			if( ! input.isEmpty()) this.inFile = input;
			
			System.out.printf("Write results in, default [%s]: ", outFile);
			input = scanner.nextLine();
			if( ! input.isEmpty()) this.outFile = input;
		}
		
		ScannerData sd = new ScannerData();
		sd.setInputFile(inFile);
		sd.setOutputFile(outFile);
		
		return sd;
	}

}
