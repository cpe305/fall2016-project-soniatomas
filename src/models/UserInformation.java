package models;

public class UserInformation {
	
	private String username;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private ProductHistory productHistory;
	
	/**
	 * Constructor for User
	 * for this implementation password is set to null because it will be handled by PasswordHandler
	 * which hasnt been implemented
	 * initialized productHistory
	 * @param username
	 * @param firstName
	 * @param lastName
	 * @param password
	 * @param email
	 */
	public UserInformation(String username, String firstName, String lastName, String password, String email)
	{
	}
	/**
	 * return User's username
	 * @return
	 */
	public String getUsername()
	{
		return null;
	}
	/**
	 * set the username of the user
	 * @param username
	 */
	public void setUsername(String username)
	{
		
	}
	/**
	 * returns User's First Name
	 * @return
	 */
	public String getFirstName()
	{
		return null;
	}
	/**
	 * set the firstName of User
	 * @param username
	 */
	public void setFirstName(String firstName)
	{
		
	}
	/**
	 * return User's Last Name;
	 * @return
	 */
	public String getLastName()
	{
		return null;
	}
	/**
	 * set User's last name
	 * @param lastName
	 */
	public void setLastName(String lastName)
	{
		
	}
	/**
	 * Do not implement
	 * Uses determinePasswordHash from PasswordHandler. PasswordHandler has not been implemented
	 * and therefore it will return null in the meantime.
	 * @return null
	 */
	public String getPasswordHash()
	{
		return null;
	}
	/**
	 * set the User password
	 * Do not implement 
	 * will rely on PasswordHandler which has not been implemented
	 * @param username
	 */
	public void setPassword(String password)
	{
		
	}
	/**
	 * returns User's email
	 * @return
	 */
	public String getEmail()
	{
		return null;
	}
	/**
	 * set the User email
	 * @param email
	 */
	public void setEmail(String email)
	{
		
	}
	
}
