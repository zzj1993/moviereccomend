package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import main.Main;

import org.junit.Before;
import org.junit.Test;

import controller.Director;
import controller.Genre;
import controller.GenreList;
import controller.Movie;
import controller.MovieList;
import controller.Origin;
import controller.Recommendation;
import controller.StarList;
import controller.Stars;
import controller.Tag;
import controller.TagList;
import controller.UserMovie;


public class TestMovieTest {
	ArrayList<Genre> tmpGenreList = new ArrayList<Genre>();
	Genre genre1 = new Genre("fantastic" , 0);
	ArrayList<Tag> tmpTagList = new ArrayList<Tag>();
	Tag tag1 = new  Tag("murder" , 0);
	Stars star1 = new Stars("Brad Pitt", 0 );
	ArrayList<Stars> tmpStarList = new ArrayList<Stars>();
	Movie movie1 = new Movie(new GenreList(tmpGenreList), new TagList(tmpTagList),  new Director("martin" , 0), new Origin("Hollywood" ,0), new StarList(tmpStarList), "Get me",1, 1999, 8,"");
	@Before
	
	 //==================================
   //=            Test cases          =
   //==================================
	
	
	@Test
	public void genreAddTest(){
		tmpGenreList.add(genre1);
		 assertEquals("fantastic", tmpGenreList.get(0).getGenreName());
	}
	
	@Test
	public void tagAddTest(){
		tmpTagList.add(tag1);
		 assertEquals("murder", tmpTagList.get(0).getTagName());
	}
	
	@Test
	public void starsAddTest(){
		tmpStarList.add(star1);
		assertEquals("Brad Pitt", tmpStarList.get(0).getStarName());
		
	}
	@Test
	public void controlRating(){
		
		MovieList list = new MovieList();
		list.getMovieList().add(movie1);
		UserMovie userMovie = new UserMovie(new Genre("fantastic" , 0), new Tag("love" , 0), new Director("jack", 0), new Origin("Bollywood" ,0), new Stars( "emre metin" , 0 ) , 10);
		Recommendation recommend = new Recommendation(list, userMovie);
		MovieList tmpList = recommend.searchMovie();
		
		assertEquals(8,tmpList.getMovieList().get(0).getRating());
		
			
	}   
	
	    @Test
		public void isReturnMovie(){
			MovieList list = new MovieList();
			list.getMovieList().add(movie1);
			UserMovie userMovie = new UserMovie(new Genre("fantastic" , 0), new Tag("love" , 0), new Director("jack", 0), new Origin("Bollywood" ,0), new Stars( "emre metin" , 0 ) , 10);
			Recommendation recommend = new Recommendation(list, userMovie);
			MovieList tmpList = recommend.searchMovie();
			assertNotNull(tmpList);
		}
	    
	    @Test
		public void directorAddTest(){
			Director director = new Director ("alex", 0);
			assertEquals("alex",director.getDirectorName());
	    }
		
	    @Test
		public void originAddTest(){
			Origin origin = new Origin("hollywood", 0);
			assertEquals("hollywood", origin.getOriginName());
	    }
	    
	    
	    
	    


}
