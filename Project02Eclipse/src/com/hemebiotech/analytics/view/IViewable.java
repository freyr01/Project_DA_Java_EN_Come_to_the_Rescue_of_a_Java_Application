package com.hemebiotech.analytics.view;

/**
 * Interface IViewable represent what a view have to do
 * @author Mathias Lauer
 * 7 nov. 2020
 */
public interface IViewable {
	
	/**
	 * Get the path to the file containing symptoms list
	 * @author Mathias Lauer
	 * 7 nov. 2020
	 * @return Path to the symptoms list file.
	 */
	public String getInputFile();
	
	/**
	 * Get the path of the file will contain the result
	 * @author Mathias Lauer
	 * 7 nov. 2020
	 * @return Path to the file will be write
	 */
	public String getOutputFile();

	/**
	 * Show an error
	 * @author Mathias Lauer
	 * 8 nov. 2020
	 * @param error as a String.
	 */
	public void showError(String error);
}
