package com.hemebiotech.analytics.view;

/**
 * Interface IViewable represent what a view have to do
 * @author Mathias Lauer
 * 7 nov. 2020
 */
public interface IViewable {
	
	/**
	 * Ask the user the path to the file containing symptoms list
	 * @author Mathias Lauer
	 * 7 nov. 2020
	 * @return String path to the symptoms list file.
	 */
	public String askInputFile();
	
	/**
	 * Ask the user the path of the file will contain the result
	 * @author Mathias Lauer
	 * 7 nov. 2020
	 * @return String path to the file will be write
	 */
	public String askOutputFile();

}
