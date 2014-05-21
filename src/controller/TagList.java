package controller;

import java.util.ArrayList;

public class TagList {
	
	private ArrayList<Tag> tagList = new ArrayList<Tag>();
	
	public TagList() {
		super();
	}
	
	public TagList(ArrayList<Tag> tagList) {
		super();
		this.tagList = tagList;
	}
	
	public ArrayList<Tag> getTagList() {
		return tagList;
	}
	
	public void setTagList(ArrayList<Tag> tagList) {
		this.tagList = tagList;
	}

	
}
