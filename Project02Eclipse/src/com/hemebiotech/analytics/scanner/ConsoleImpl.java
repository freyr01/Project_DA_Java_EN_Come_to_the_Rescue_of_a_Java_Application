package com.hemebiotech.analytics.scanner;

import java.util.Scanner;

public class ConsoleImpl implements IScanner {
	private String inFile = "symptoms.txt";
	private String outFile = "result.out";
	
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
