package model;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
* <b>Description:</b> The class Event in the package model.<br>
* @author Johan Giraldo.
*/

public class Event {
	
//Attributes
	
	private String path;
	private Spectator root;
	private Competitor first;
	
//Constructor
	
	/**
	 * <b>Description:</b> The constructor of the class Spectator.<br>
	 * <b>Post:</b> All attributes of the class are initialized.<br> 
	 * @param path The path of the file that have the information of the event.
	 * @throws InvalidPathException If the file doesn't exist or couldn't be found.
	 */
	
	public Event(String path) throws InvalidPathException {
		
		File file = new File(path);
		
		if(!file.exists()) {
			
			throw new InvalidPathException();
		}
		
		this.path = path;
		root = null;
		first = null;
	}
	
//Getters
	
	/**
	 * <b>Description:</b> This method allows returning the attribute path.<br>
	 * @return The attribute path.
	 */
	
	public String getPath() {
		return path;
	}
	
	/**
	 * <b>Description:</b> This method allows returning the attribute root.<br>
	 * @return The attribute root.
	 */
	
	public Spectator getRoot() {
		return root;
	}
	
	/**
	 * <b>Description:</b> This method allows returning the attribute first.<br>
	 * @return The attribute first.
	 */
	
	public Competitor getFirst() {
		return first;
	}
	
//Setters
	
	/**
	 * <b>Description:</b> This method allows setting the attribute root.<br>
	 * <b>Post:</b> The attribute root will be replaced by the one that enters by parameter.<br>
	 */

	public void setRoot(Spectator root) {
		this.root = root;
	}
	
	/**
	 * <b>Description:</b> This method allows setting the attribute first.<br>
	 * <b>Post:</b> The attribute first will be replaced by the one that enters by parameter.<br>
	 * @param first The new first.
	 */

	public void setFirst(Competitor first) {
		this.first = first;
	}
	
//Methods
	
	/**
	 * <b>Description:</b> This method allows loading the spectator and competitors form a text file.<br>
	 * <b>Post:</b> The spectators and competitor was loaded.<br>
	 * <b>Pre:</b> The file must exist.<br>
	 */
	
	public String loadData() {
		
		FileReader file;
		BufferedReader reader;
		String[] attributes;
		String line;
		String msg = "";
		
		try{
			
			file = new FileReader(path);
			reader = new BufferedReader(file);
			attributes = new String[7];
			
			while((line = reader.readLine()) != null){
				
					attributes = line.split(",");
					Spectator spectator = new Spectator(attributes[0], attributes[1], attributes[2], attributes[3], attributes[4], attributes[5], attributes[6]);
					
					try {
						
						addSpectator(spectator);
					}
					catch(InvalidIdException e) {
						
						msg += e.getMessage() + "\n";
					}
			}
			
			reader.close();
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		return msg;
	}
	
	/**
	 * <b>Description:</b> This method allows adding a spectator in the BST of spectators.<br>
	 * <b>Post:</b> The spectator was added on the BST of spectators.<br>
	 * @param spectator The spectator that will be added - spectator != null.
	 * @throws InvalidIdException If spectator has the same id that other spectator that already is in the BST.
	 */
	
	public void addSpectator(Spectator spectator) throws InvalidIdException {
		
		if(root == null) {
			
			root = spectator;
		}
		else {
			
			root.addSpectator(spectator);
		}
	}
	
	/**
	 * <b>Description:</b> This method allows adding a competitor in the doubly linked list of competitors.<br>
	 * <b>Post:</b> The competitor was added on the doubly linked list of competitors.<br>
	 * @param competitor The competitor that will be added - competitor != null.
	 */
	
	public void addCompetitor(Competitor competitor) {
		
		if(first == null) {
			
			first = competitor;
		}
		else {
			
			first.addCompetitor(competitor);
		}
	}
	
	/**
	 * <b>Description:</b> This method allows getting a spectator of the BST of spectators by the id.<br> 
	 * @param id The spectator's id - spectator != null.
	 * @return The spectator if it could be found or null if it couldn't be found.
	 */
	
	public Spectator getSpectatorById(String id) {
		
		Spectator spectator = null;
		
		if(root != null) {
			
			spectator = new Spectator(id, "", "", "", "", "", "");
			spectator = root.getSpectatorById(spectator);
			
		}
		
		return spectator;
	}
	
	/**
	 * <b>Description:</b> This method allows getting a random spectator of the BST of spectators.<br>
	 * @return a random spectator of the BST of spectators, if the BST is empty, return null.
	 */
	
	public Spectator selectRandomSpectator() {
		
		Spectator spectator = null;
		
		if(root != null) {
			
			spectator = root.selectRandomSpectator();
		}
		
		return spectator;
	}
	
	/**
	 * <b>Description:</b> This method allows getting the spectator's father.<br> 
	 * @param spectator The spectator that do you want to find the father - spectator != null.
	 * @return The spectator's father if it could be found, null if not.
	 */
	
	public Spectator getFather(Spectator spectator) {
		
		Spectator father = null;
		
		if(root != null) {
			
			father = root.getFather(spectator, null);
		}
		
		return father;
	}
	
	/**
	 * <b>Description:</b> This method allows getting a the BST of spectators size.<br>
	 * @return the BST of spectators size.
	 */
	
	public int getSizeBST() {
		
		int size = 0;
		
		if(root != null) {
			
			size = root.getSizeBST(root);
		}
		
		return size;
	}
	
	/**
	 * <b>Description:</b> This method allows deleting a spectator of the BST of spectators.<br>
	 * <b>Post:</b> The spectator was deleted of the BST of spectators.<br>
	 * @param spectator The spectator that will be deleted - spectator != null.
	 */
	
	public void deleteSpectator(Spectator spectator) {
		
		Spectator tmp;
		
		if(spectator == root) {
			
			tmp = spectator.deleteSpectator();
			
			if(tmp == root) {
				
				setRoot(null);
				
			}
			else {
				
				setRoot(tmp);
			}
		}
		else {
			
			tmp = spectator.deleteSpectator();
			Spectator father = getFather(spectator);
			
			if(spectator == father.getLeftChild()) {
				
				if(tmp == spectator) {
					
					father.setLeftChild(null);
				}
				else {
					
					father.setLeftChild(tmp);
				}
			}
			else {
				
				if(tmp == spectator) {
					
					father.setRightChild(null);
				}
				else {
					
					father.setRightChild(tmp);
				}
			}
		}
	}
	
	/**
	 * <b>Description:</b> This method allows getting the size of the doubly linked list of competitors.<br>
	 * @return The size of the doubly linked list of competitors.
	 */
	
	public int getSize() {
		
		int size = 0;
		
		if(first != null) {
			
			size = first.getSize();
		}
		
		return size;
	}
	
	/**
	 * <b>Description:</b> This method allows adding randomly in the doubly linked list of competitors the 50% of the spectators in the BST of spectators as competitors.<br>
	 * <b>Post:</b> The competitors was added in the doubly linked list of competitors.<br>
	 */
	
	public void addCompetitors() {
		
		int sizeBST = (getSizeBST() / 2);
		int counter = 0;
		
		while(counter < sizeBST) {
			
			Spectator tmp = selectRandomSpectator();
			deleteSpectator(tmp);
			addCompetitor(new Competitor(tmp.getId(), tmp.getFirstName(), tmp.getLastName(), tmp.getEmail(), tmp.getGender(), tmp.getNationality(), tmp.getBirthdate()));
			counter++;
		}
	}
	
	/**
	 * <b>Description:</b> This method allows showing a spectator and the time that took found it.<br>
	 * @param id The spectator id.
	 * @return The spectator's attributes and the time that took found it.
	 */
	
	public String searchSpectator(String id) {
		
		String msg = "";
		long t1, t2, delta;
		
		t1 = System.nanoTime();
		
		Spectator spectator = getSpectatorById(id);
		
		t2 = System.nanoTime();
		
		delta = t2 - t1;
		
		if(spectator != null) {
			
			msg = spectator.toString() + "\n";
			msg += "The search took: " + delta + "ns";
		}else {
			
			msg = "The spectator couldn't be found.\n\nThe search took: " + delta + "ns";
		}
		
		return msg;
	}
}
