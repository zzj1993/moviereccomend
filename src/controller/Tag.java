package controller;

public class Tag {
	
	/*This class using for create tag.Next iteration  we use database connection
	 * to get tag name and ID.Tag name cannot be null and 
	 * tagID should be 0 or positive integer number
	 */

	private String tagName;
	private int tagID;
	
	public Tag() {
		super();
	}

	public Tag(String tagName, int tagID) {
		super();
		this.tagName = tagName;
		this.tagID = tagID;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		if(tagName != null)
			this.tagName = tagName;
		else
			throw new NullPointerException("Tag has to have a name!");
	}

	public int getTagID() {
		return tagID;
	}

	public void setTagID(int tagID) {
		if(tagID >= 0)
			this.tagID = tagID;
		else
			this.tagID = -1;
	}
	
	
	
}
