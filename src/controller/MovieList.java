package controller;

import java.util.ArrayList;


public class MovieList {
	
	@SuppressWarnings("unused")
	private Movie tmpMovie = new Movie();
	private Movie typedMovie = new Movie();
	private ArrayList<Movie> movieList = new ArrayList<Movie>();
	
	public MovieList() {
		super();
	}
	
	public Movie getTypedMovie() {
		return typedMovie;
	}
	public void setTypedMovie(Movie typedMovie) {
		this.typedMovie = typedMovie;
	}
	public ArrayList<Movie> getMovieList() {
		return movieList;
	}
	public void setMovieList(ArrayList<Movie> movieList) {
		this.movieList = movieList;
	}

	
	
	
}
