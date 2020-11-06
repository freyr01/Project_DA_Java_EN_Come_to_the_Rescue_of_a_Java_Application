package com.hemebiotech.analytics.scanner;

/**
 * Instance of this contain data to use the application.
 * @author Mathias Lauer
 * 6 nov. 2020
 */
public class ScannerData {
	
	private String inputFile;
	private String outputFile;
	
	public String getInputFile() {
		return inputFile;
	}
	public void setInputFile(String inputFile) {
		this.inputFile = inputFile;
	}
	public String getOutputFile() {
		return outputFile;
	}
	public void setOutputFile(String outputFile) {
		this.outputFile = outputFile;
	}

}
