package controller;

public class Origin {
	
	/*This class using for create origin.Next iteration  we use database connection
	 * to get origin name and ID.origin name cannot be null and 
	 * originID should be 0 or positive integer number
	 */
	
	private String originName;
	private int originID;
	
	public Origin() {
		super();
	}

	public Origin(String originName, int originID) {
		super();
		this.originName = originName;
		this.originID = originID;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		if(originName != null)
			this.originName = originName;
		else
			throw new NullPointerException("Origin has to have a name");
	}

	public int getOriginID() {
		return originID;
	}

	public void setOriginID(int originID) {
		if(originID >= 0)
			this.originID = originID;
		else
			this.originID = -1;
	}
}
