package main;

import java.sql.SQLException;

import mySQL.MySQLPersistence;
import controller.*;

public class Main {
	
	/*After the elaboration 1, we design and connect database
	 * to try our system, we insert 10 sample movie.
	 * Here is 2 sample result to get information about films.
	 * we
	 * */
	
	public static void main(String[] args) throws SQLException{
		
		MySQLPersistence connection = new MySQLPersistence();
		
		int i;
		
		//get the all movies from database
		for(i = 0; i < connection.getAllMovie().getMovieList().size(); i++){
			//print the movie name firstly
			System.out.printf(connection.getAllMovie().getMovieList().get(i).getMovieName() + " is played ");
			//then print the actor and actress in the that movie
			for(int j = 0; j<connection.getAllMovie().getMovieList().get(i).getStar().getStarsList().size();j++)
				System.out.printf(connection.getAllMovie().getMovieList().get(i).getStar().getStarsList().get(j).getStarName() + " and ");
			System.out.printf("directed by ");
			//also print the director of this film
			System.out.println(connection.getAllMovie().getMovieList().get(i).getDirector().getDirectorName());
		}
		
		System.out.println();
		System.out.println();
		
		//get the all movies from database
		for(i = 0 ; i < connection.getAllMovie().getMovieList().size(); i++){
			//print the movie name firstly
			System.out.printf(connection.getAllMovie().getMovieList().get(i).getMovieName() + " is tag names' ");
			//then print the tags about the film
			for(int j = 0 ; j < connection.getAllMovie().getMovieList().get(i).getTag().getTagList().size();j++)
				System.out.printf(connection.getAllMovie().getMovieList().get(i).getTag().getTagList().get(j).getTagName() + ",");
			System.out.println();
		}
		
		System.out.println();
		System.out.println();
		
		//making new user movie, after UI design, we make it in UI.
		UserMovie userMovie = new UserMovie(new Genre("Drama" , 1), new Tag("boxer" , 1), new Director("martin", 1), new Origin("Hollywood" ,1), new Stars( "Brad Pitt" , 1 ) , 8);
		//start recommendation system
		Recommendation recommend = new Recommendation(connection.getAllMovie(), userMovie);
		//get movie list that result of recommendation
		MovieList tmpList = recommend.searchMovie();
		for(i = 0 ; i < tmpList.getMovieList().size() ; i++){
			//print the highest movie with the score
			System.out.print(tmpList.getMovieList().get(i).getMovieName() + " get ");
			System.out.println(tmpList.getMovieList().get(i).getRating() + " score!");

		}

	}

}
