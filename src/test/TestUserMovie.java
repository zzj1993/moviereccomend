package test;

import static org.junit.Assert.*;
import controller.Director;
import controller.Genre;
import controller.Origin;
import controller.Stars;
import controller.Tag;
import controller.UserMovie;

import org.junit.Test;

public class TestUserMovie {
	
	UserMovie userMovie =new UserMovie(new Genre("fantastic" , 0), new Tag("murder" , 0), new Director("martin", 0), new Origin("Hollywood" ,0), new Stars( "emre metin" , 0 ) ,  8);
	
	@Test
	public void isGenreSet(){
		assertEquals("fantastic" , userMovie.getGenre().getGenreName());
	}
	
	@Test
	public void isTagSet(){
		assertEquals("murder" , userMovie.getTag().getTagName());
	}
	
	@Test
	public void isDirectorSet(){
		assertEquals("martin" , userMovie.getDirector().getDirectorName());
	}
	
	@Test
	public void isOriginSet(){
		assertEquals("Hollywood" , userMovie.getOrigin().getOriginName());
	}
	
	@Test
	public void isStarSet(){
		assertEquals("emre metin" , userMovie.getStar().getStarName());
	}
	
	
	@Test
	public void isImdbRatingSet(){
		assertEquals(8 , userMovie.getImdbRating());
	}
	

}
