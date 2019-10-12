package model;

/**
*<b>Description:</b> The class Person in the package model.<br>
*@author Johan Giraldo.
*/

public abstract class Person {

//Attributes
	
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String gender;
	private String nationality;
	private String birthdate;
		
//Constructor
		
	/**
	 *<b>Description:</b> The constructor of the class Spectator.<br>
	 *<b>Pre:</b> No one parameter can be null.<br>
	 *<b>Post:</b> All attributes of the class are initialized.<br> 
	 * @param id The person's id.
	 * @param firstName The person's first name.
	 * @param lastName The person's last name.
	 * @param email The person's email.
	 * @param gender The person's gender.
	 * @param country The person's country.
	 * @param birthdate The person's birthdate.
	 */
		
	public Person(String id, String firstName, String lastName, String email, String gender, String nationality, String birthdate) {
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
	    this.nationality = nationality;
		this.birthdate = birthdate;
	}
		
//Getters
	
	/**
	 *<b>Description:</b> This method allows returning the attribute id.<br>
	 *@return The attribute id.
	 */
		
	public String getId() {
		return id;
	}
}
