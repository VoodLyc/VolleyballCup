package model;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
*<b>Description:</b> The class Event in the package model.<br>
*@author Johan Giraldo.
*/

public class Event {
	
//Attributes
	
	private String path;
	private Spectator root;
	private Competitor first;
	
//Constructor
	
	/**
	 *<b>Description:</b> The constructor of the class Spectator.<br>
	 *<b>Post:</b> All attributes of the class are initialized.<br> 
	 * @param path The path of the file that have the information of the event.
	 * @throws InvalidPathException If the file doesn't exist or couldn't be found.
	 */
	
	public Event(String path) throws InvalidPathException {
		
		this.path = path;
		File file = new File(path);
		
		if(!file.exists()) {
			
			throw new InvalidPathException();
		}
		
		root = null;
		first = null;
	}
	
//Getters
	
	/**
	 *<b>Description:</b> This method allows returning the attribute path.<br>
	 *@return The attribute path.
	 */
	
	public String getPath() {
		
		return path;
	}
	
	/**
	 *<b>Description:</b> This method allows returning the attribute root.<br>
	 *@return The attribute root.
	 */
	
	public Spectator getRoot() {
		return root;
	}
	
	/**
	 *<b>Description:</b> This method allows returning the attribute first.<br>
	 *@return The attribute first.
	 */
	
	public Competitor getFirst() {
		return first;
	}
	
//Setters
	
	/**
	 *<b>Description:</b> This method allows setting the attribute root.<br>
	 *<b>Post:</b> The attribute root will be replaced by the one that enters by parameter.<br>
	 *@param root The new root.
	 */

	public void setRoot(Spectator root) {
		this.root = root;
	}
	
	/**
	 *<b>Description:</b> This method allows setting the attribute first.<br>
	 *<b>Post:</b> The attribute first will be replaced by the one that enters by parameter.<br>
	 *@param first The new first.
	 */

	public void setFirst(Competitor first) {
		this.first = first;
	}
	
//Methods

}
