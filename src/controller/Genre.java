package controller;

public class Genre {
	
	/*This class using for create genre.Next iteration  we use database connection
	 * to get genre name and ID.Genre name cannot be null and 
	 * genreID should be 0 or positive integer number
	 */

	private String genreName;
	private int genreInt;	
	
	public Genre() {
		super();
	}
	public Genre(String genreName, int genreInt) {
		super();
		this.genreName = genreName;
		this.genreInt = genreInt;
	}
	public String getGenreName() {
		return genreName;
	}
	public void setGenreName(String genreName) {
		if(genreName != null)
			this.genreName = genreName;
		else
			throw new NullPointerException("Genre Name cannot be null");
	}
	public int getGenreInt() {
		return genreInt;
	}
	public void setGenreInt(int genreInt) {
		if(genreInt >= 0)
			this.genreInt = genreInt;
		else
			this.genreInt = -1;
	}
	
	
}
