package model;

/**
*<b>Description:</b> The class Spectator in the package model.<br>
*@author Johan Giraldo.
*/

public class Spectator extends Person implements Comparable <Spectator> {
	
//Attributes
	
	private Spectator leftChild;
	private Spectator RightChild;
	
//Constructor
	
	/**
	 *<b>Description:</b> The constructor of the class Spectator.<br>
	 *<b>Pre:</b> No one parameter can be null.<br>
	 *<b>Post:</b> All attributes of the class are initialized.<br> 
	 * @param id The spectator's id.
	 * @param firstName The spectator's first name.
	 * @param lastName The spectator's last name.
	 * @param email The spectator's email.
	 * @param gender The spectator's gender.
	 * @param country The spectator's country.
	 * @param birthdate The spectator's birthdate.
	 */
	
	public Spectator(String id, String firstName, String lastName, String email, String gender, String nationality, String birthdate) {
		
		super(id, firstName, lastName, email, gender, nationality, birthdate);
		leftChild = null;
		RightChild = null;
	}
	
//Methods
	
	/**
	 *<b>Description:</b> This method allows comparing a spectator with other spectator by the id.<br>
	 *<b>Pre:</b> Spectator must be != null.<br>
	 *@param spectator The spectator with which it compares.
	 *@return 0 if the IDs are equals, 1  if the spectator's id is major than the spectator's id which it compares, -1 if the spectator's id is minor than the spectator's id which it compares.
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
		
		return 0;
	}
}
