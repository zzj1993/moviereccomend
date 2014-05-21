package controller;

public class Stars {

	/*This class using for create Stars.Next iteration  we use database connection
	 * to get star name and ID.Star name cannot be null and 
	 * starID should be 0 or positive integer number
	 */
	
	private int starID;
	private String starName;	
	
	public Stars() {
		super();
	}
	public Stars(String starName,int starID) {
		super();
		
		this.starName = starName;
		this.starID = starID;
	}
	public int getStarID() {
		return starID;
	}
	public void setStarID(int starID) {
		if(starID >= 0)
			this.starID = starID;
		else
			this.starID = -1;
	}
	public String getStarName() {
		return starName;
	}
	public void setStarName(String starName) {
		if(starName != null)
			this.starName = starName;
		else
			throw new NullPointerException("Star has to have a name!");
	}

	
}
