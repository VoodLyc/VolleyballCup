package model;

/**
* <b>Description:</b> The class Spectator in the package model.<br>
* @author Johan Giraldo.
*/

public class Spectator extends Person implements Comparable <Spectator> {
	
//Attributes
	
	private Spectator leftChild;
	private Spectator rightChild;
	
//Constructor
	
	/**
	 * <b>Description:</b> The constructor of the class Spectator.<br>
	 * <b>Pre:</b> No one parameter can be null.<br>
	 * <b>Post:</b> All attributes of the class are initialized.<br> 
	 * @param id The spectator's id.
	 * @param firstName The spectator's first name.
	 * @param lastName The spectator's last name.
	 * @param email The spectator's email.
	 * @param gender The spectator's gender.
	 * @param nationality The spectator's nationality.
	 * @param birthdate The spectator's birthdate.
	 */
	
	public Spectator(String id, String firstName, String lastName, String email, String gender, String nationality, String birthdate) {
		
		super(id, firstName, lastName, email, gender, nationality, birthdate);
		leftChild = null;
		rightChild = null;
	}
	
//Getters
	
	/**
	 * <b>Description:</b> This method allows returning the attribute leftChild.<br>
	 * @return The attribute leftChild.
	 */

	public Spectator getLeftChild() {
		return leftChild;
	}
	
	/**
	 * <b>Description:</b> This method allows returning the attribute rightChild.<br>
	 * @return The attribute rightChild.
	 */

	public Spectator getRightChild() {
		return rightChild;
	}
	
//Methods
	
	/**
	 * <b>Description:</b> This method allows comparing a spectator with other spectator by the id.<br>
	 * @param spectator The spectator with which it compares - spectator != null. 
	 * @return 0 if the IDs are equals, 1  if the spectator's id is major than the spectator's id which it compares, -1 if the spectator's id is minor than the spectator's id which it compares.
	 */

	@Override
	public int compareTo(Spectator spectator) {
		
		int id = Integer.parseInt(getId());
		int id2 = Integer.parseInt(spectator.getId());
		int result = 0;
		
		if(id > id2) {
			
			result = 1;
		}
		else if(id < id2) {
			
			result = -1;
		}
		
		return result;
	}
	
	/**
	 * <b>Description:</b> This method allows adding a spectator in the BST of spectators.<br>
	 * <b>Post:</b> The spectator was added on the BST of spectators.<br>
	 * @param spectator The spectator that will be added - spectator != null.
	 * @throws InvalidIdException If spectator has the same id that other spectator that already is in the BST.
	 */
	
	public void addSpectator(Spectator spectator) throws InvalidIdException {
		
		if(this.compareTo(spectator) == 1) {
			
			if(rightChild == null) {
				
				rightChild = spectator;
			}
			else {
				
				rightChild.addSpectator(spectator);
			}
		}
		else if(this.compareTo(spectator) == -1) {
			
			if(leftChild == null) { 
				
				leftChild = spectator;
			}
			else {
				
				leftChild.addSpectator(spectator);
			}
		}
		else {
			
			throw new InvalidIdException(spectator.getId());
		}
	}
	
	/**
	 * <b>Description:</b> This method allows getting a spectator of the BST of spectators.<br> 
	 * @param spectator The spectator with the id - spectator != null.
	 * @return The spectator if it could be found, null if not.
	 */
	
	public Spectator getSpectatorById(Spectator spectator) {
		
		Spectator spectator1 = null;
		
		if(this.compareTo(spectator) == 0) {
			
			spectator1 = this;
		}
		else if(this.compareTo(spectator) == 1) {
			
			if(rightChild != null) {
				
				spectator1 = rightChild.getSpectatorById(spectator);
			}
		}
		else if(this.compareTo(spectator) == -1) {
			
			if(leftChild != null) {
				
				spectator1 = leftChild.getSpectatorById(spectator);
			}
		}
		
		return spectator1;
	}
	
	/**
	 * <b>Description:</b> This method allows getting the spectator's father.<br> 
	 * @param spectator The spectator that do you want to find the father - spectator != null.
	 * @param root The spectator's father, initially should be null.
	 * @return The spectator's father if it could be found, null if not.
	 */
	
	public Spectator getFather(Spectator spectator, Spectator root) {
		
		Spectator father = null;
		
		if(this.compareTo(spectator) == 0) {
			
			father = root;
		}
		else if(this.compareTo(spectator) == 1) {
			
			if(rightChild != null) {
				
				father = rightChild.getFather(spectator, this);
			}
		}
		else if(this.compareTo(spectator) == -1) {
			
			if(leftChild != null) {
				
				father = leftChild.getFather(spectator, this);
			}
		}
		
		return father;
	}
	
	/**
	 * <b>Description:</b> This method allows getting a random spectator of the BST of spectators.<br>
	 * @return a random spectator of the BST of spectators.
	 */
	
	public Spectator selectRandomSpectator() {
		
		Spectator spectator;
		
		if((int)(Math.random() * 100) >= 10) {
			
			spectator = this;
		}
		else if((int)(Math.random() * 100) >= 50) {
			
			if(leftChild != null) {
				
				spectator = leftChild.selectRandomSpectator();
			}
			else {
				
				spectator = this;
			}
		}
		else {
			
			if(rightChild != null) {
				
				spectator = rightChild.selectRandomSpectator();
			}
			else {
				
				spectator = this;
			}
		}
		
		return spectator;
	}
	
	/**
	 * <b>Description:</b> This method allows getting a the BST of spectators size.<br>
	 * @param root The root of the BST of spectators.
	 * @return the BST of spectators size.
	 */
	
	public int getSizeBST(Spectator root) {
		
		int size = 0;
		
		if(root == null) {
			
			size = 0;
		}
		else {
			
			size = 1 + getSizeBST(root.leftChild) + getSizeBST(root.rightChild);
		}
		
		return size;
	}
}
