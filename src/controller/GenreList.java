package controller;

import java.util.ArrayList;

public class GenreList {
	
	private ArrayList<Genre> genreList = new ArrayList<Genre>();
	
	public GenreList() {
		super();
	}

	public GenreList( ArrayList<Genre> genreList) {
		super();
		this.genreList = genreList;
	}

	public ArrayList<Genre> getGenreList() {
		return genreList;
	}
	
	public void setGenreList(ArrayList<Genre> genreList) {
		if (genreList != null)
			this.genreList = genreList;
		else
			throw new NullPointerException("GenreList must contain at least 1 genre");
	}
	
	
	
	
	
	
	
}
