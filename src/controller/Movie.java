package controller;

public class Movie {

	/*This class using for create movie.Next iteration  we use database connection
	 * to get all information about movie.Movie has to have name, genre and director.
	 * These variables cannot be null. 
	 */

	
	private GenreList genreList = new GenreList();
	private TagList tagList = new TagList();
	private Director director = new Director();
	private Origin origin = new Origin();
	private StarList starList = new StarList();
	private String movieName;
	private int movieID;
	private int year;
	private int rating = 0;
	private int imdbRating;
	private String description;
	
	public Movie() {
		super();
	}
	
	public Movie(GenreList genre, TagList tag, Director director, Origin origin,
			StarList star, String movieName,int movieID, int year,  int imdbRating,String description) {
		super();
		this.genreList = genre;
		this.tagList = tag;
		this.director = director;
		this.origin = origin;
		this.starList = star;
		this.movieName = movieName;
		this.movieID = movieID;
		this.year = year;
		this.imdbRating = imdbRating;
		this.description = description;
	}
	
	public GenreList getGenre() {
		return genreList;
	}
	
	public void setGenre(GenreList genre) {
		if(genre == null)
			this.genreList = genre;
		else
			throw new NullPointerException("Movie has at least 1 genre!");
	}
	
	public TagList getTag() {
		return tagList;
	}
	
	public void setTag(TagList tag) {
		this.tagList = tag;
	}
	
	public Director getDirector() {
		return director;
	}
	
	public void setDirector(Director director) {
		if(director == null)
			this.director = director;
		else
			throw new NullPointerException("Movie has to contain director");
	}
	
	public Origin getOrigin() {
		return origin;
	}
	
	public void setOrigin(Origin origin) {
		this.origin = origin;
	}
	
	public StarList getStar() {
		return starList;
	}
	
	public void setStar(StarList star) {
		this.starList = star;
	}
	
	public String getMovieName() {
		return movieName;
	}
	
	public void setMovieName(String movieName) {
		if(movieName != null)
			this.movieName = movieName;
		else
			throw new NullPointerException("Movie has to have movie name");
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public int getRating() {
		return rating;
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public int getImdbRating() {
		return imdbRating;
	}
	
	public void setImdbRating(int imdbRating) {
		this.imdbRating = imdbRating;
	}

	public int getMovieID() {
		return movieID;
	}

	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
