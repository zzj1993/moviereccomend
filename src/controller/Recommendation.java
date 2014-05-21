package controller;

import java.util.ArrayList;

public class Recommendation {
	/*For the recommendation we will use score algorithm that we create.
	 * Firstly, we get our movie list and user movie
	 * then, get first movie from our list and compare with user's choices. 
	 * */

	private MovieList list = new MovieList();
	private UserMovie userMovie = new UserMovie();
	private ArrayList<Movie> movies = new ArrayList<Movie>();
	private MovieList recommendationList = new MovieList();
	public MovieList getList() {
		return list;
	}
	public void setList(MovieList list) {
		this.list = list;
	}
	public UserMovie getMv() {
		return userMovie;
	}
	public void setMv(UserMovie mv) {
		this.userMovie = mv;
	}
	public Recommendation(MovieList list, UserMovie userMovie) {
		super();
		this.list = list;
		this.userMovie = userMovie;
	}
	
	//with searchMovie we traverse in our movie list.
	public MovieList searchMovie(){
		for(int i = 0; i< list.getMovieList().size(); i++){
			//take the movie
			Movie tmpMovie = list.getMovieList().get(i);
			//get the score with isAdded function
			if(isAdded(tmpMovie)){
				recommendationList.setMovieList(movies);
				recommendationList.getMovieList().add(tmpMovie);
			}
		}
		
		return sortMovieList(recommendationList);
	}
	
	//this function supply to get score for movie 
	//with compare our movie's features and user's wanted feature.
	private boolean isAdded(Movie tmpMovie){
		//if our movie contain genre that user want, get score 8
		for(int i = 0 ; i < tmpMovie.getGenre().getGenreList().size() ; i++){
			if(tmpMovie.getGenre().getGenreList().get(i).getGenreName().equals(userMovie.getGenre().getGenreName()))
				tmpMovie.setRating(tmpMovie.getRating() + 8);
		}
		//if our movie contain tag that user want, get score 10
		for(int i = 0 ; i < tmpMovie.getTag().getTagList().size() ; i++){
			if(tmpMovie.getTag().getTagList().get(i).getTagName().equals(userMovie.getTag().getTagName()))
				tmpMovie.setRating(tmpMovie.getRating() + 10);			
		}
		//if our movie contain star that user want, get score 4
		for(int i = 0 ; i < tmpMovie.getStar().getStarsList().size() ; i++){
			if(tmpMovie.getStar().getStarsList().get(i).getStarName().equals(userMovie.getStar().getStarName()))
				tmpMovie.setRating(tmpMovie.getRating() + 4);
		}
		//if our movie's director is same with user's want get score 5
		if(tmpMovie.getDirector().getDirectorName().equals(userMovie.getDirector().getDirectorName()))
			tmpMovie.setRating(tmpMovie.getRating() + 5);
		
		//if our movie's origin is same with user's want get score 5
		if(tmpMovie.getOrigin().getOriginName().equals(userMovie.getOrigin().getOriginName()))
			tmpMovie.setRating(tmpMovie.getRating() + 7);
		
		//if our movie's imdb rating same or bigger than user's want get score 6
		if(tmpMovie.getImdbRating() >= userMovie.getImdbRating())
			tmpMovie.setRating(tmpMovie.getRating() + 6);
		
		//if our movie get more than that score, we add it to recommend list.
		//with bigger movie list we can increase this minimum rating.
		if(tmpMovie.getRating() > 10)
			return true;
		return false;
		
	}
	
	//basic bubble sort algorithm for the recommend list.
	//movie which has biggest rating, most suitable movie to show user. 
	private MovieList sortMovieList(MovieList movieList)
	{
		Movie tmpMovie = new Movie();
		boolean swapped = true;
		int j=0;
		while(swapped){
			swapped = false;
			j++;
			for (int i = 0 ; i < movieList.getMovieList().size() -j ; i++){
				if(movieList.getMovieList().get(i).getRating() < movieList.getMovieList().get(i+1).getRating()){
					tmpMovie = movieList.getMovieList().get(i);
					movieList.getMovieList().set(i, movieList.getMovieList().get(i+1));
					movieList.getMovieList().set(i+1, tmpMovie);
					swapped = true;
				}
			}
		}	
		return movieList;
	}
}
