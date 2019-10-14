package model;

public class Competitor extends Person {
	
//Attributes
	
	private Competitor next;
	private Competitor prev;
	
//Constructor
	
	/**
	 * <b>Description:</b> The constructor of the class Spectator.<br>
	 * <b>Pre:</b> No one parameter can be null.<br>
	 * <b>Post:</b> All attributes of the class are initialized.<br> 
	 * @param id The competitor's id.
	 * @param firstName The competitor's first name.
	 * @param lastName The competitor's last name.
	 * @param email The competitor's email.
	 * @param gender The competitor's gender.
	 * @param nationality The competitor's nationality.
	 * @param birthdate The competitor's birthdate.
	 */
		
	public Competitor(String id, String firstName, String lastName, String email, String gender, String nationality, String birthdate) {
			
		super(id, firstName, lastName, email, gender, nationality, birthdate);
		next = null;
		prev = null;
	}
	
//Setters
	
	/**
	 * <b>Description:</b> This method allows setting the attribute prev.<br>
	 * <b>Post:</b> The attribute prev will be replaced by the one that enters by parameter.<br>
	 * @param prev The new prev.
	 */
	
	public void setPrev(Competitor prev) {
		this.prev = prev;
	}
	
//Methods
	
	/**
	 * <b>Description:</b> This method allows adding a competitor in the doubly linked list of competitors.<br>
	 * <b>Post:</b> The competitor was added on the doubly linked list of competitors.<br>
	 * @param competitor The competitor that will be added - competitor != null.
	 */
	
	public void addCompetitor(Competitor competitor) {
		
		if(next == null) {
			
			next = competitor;
			competitor.setPrev(this);
		}
		else {
			
			next.addCompetitor(competitor);
		}
	}
}
