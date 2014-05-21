package controller;

import java.util.ArrayList;

public class StarList {
	
	private ArrayList<Stars> starsList = new ArrayList<Stars>();
	
	public StarList() {
		super();
	}
	public StarList( ArrayList<Stars> starsList) {
		super();
		this.starsList = starsList;
	}

	public ArrayList<Stars> getStarsList() {
		return starsList;
	}
	public void setStarsList(ArrayList<Stars> starsList) {
		this.starsList = starsList;
	}
	
}
