package controller;

public class Director {

	/*This class using for create director.Next iteration  we use database connection
	 * to get director name and ID.director name cannot be null and 
	 * directorID should be 0 or positive integer number
	 */

	public String directorName;
	public int directorId;
	public Director(String directorName, int directorId) {
		super();
		this.directorName = directorName;
		this.directorId = directorId;
	}
	public Director() {
		super();
	}
	public String getDirectorName() {
		return directorName;
	}
	public void setDirectorName(String directorName) {
		if(directorName != null)
			this.directorName = directorName;
		else
			throw new NullPointerException("Director Name cannot be null");
	}
	public int getDirectorId() {
		return directorId;
	}
	public void setDirectorId(int directorId) {
		if(directorId >= 0)
			this.directorId = directorId;
		else
			this.directorId = -1;
	}
	
	
}
