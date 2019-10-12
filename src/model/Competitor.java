package model;

public class Competitor extends Person {
	
//Attributes
	
	private Competitor next;
	private Competitor prev;
	
//Constructor
	
	/**
	 *<b>Description:</b> The constructor of the class Spectator.<br>
	 *<b>Pre:</b> No one parameter can be null.<br>
	 *<b>Post:</b> All attributes of the class are initialized.<br> 
	 * @param id The competitor's id.
	 * @param firstName The competitor's first name.
	 * @param lastName The competitor's last name.
	 * @param email The competitor's email.
	 * @param gender The competitor's gender.
	 * @param country The competitor's country.
	 * @param birthdate The competitor's birthdate.
	 */
		
	public Competitor(String id, String firstName, String lastName, String email, String gender, String nationality, String birthdate) {
			
		super(id, firstName, lastName, email, gender, nationality, birthdate);
		next = null;
		prev = null;
	}
}
