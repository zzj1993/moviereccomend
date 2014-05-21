package servlet;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mySQL.MySQLPersistence;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import controller.Director;
import controller.Genre;
import controller.MovieList;
import controller.Origin;
import controller.Recommendation;
import controller.Stars;
import controller.Tag;
import controller.UserMovie;

/**
 * Servlet implementation class recommendation
 */
@WebServlet("/recommendation")
public class recommendation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public recommendation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String genre =request.getParameter("genre");
		String tag =request.getParameter("tag");
		String origin =request.getParameter("origin");
		String director =request.getParameter("director");
		String star =request.getParameter("star");
		String imdbrating =request.getParameter("imdbrating");
		
		UserMovie userMovie = new UserMovie(new Genre(genre , 1), new Tag(tag , 1), new Director(director, 1), new Origin(origin ,1), new Stars(star , 1 ), Integer.parseInt(imdbrating));
		
		MySQLPersistence connection = new MySQLPersistence();
		
		
		
		try {
			Recommendation recommend = new Recommendation(connection.getAllMovie(), userMovie);
			MovieList recommendList = recommend.searchMovie();
			
		    ServletContext sc = getServletContext();
		    
		    request.setAttribute("recommend",recommendList.getMovieList());
		    sc.getRequestDispatcher("/recommendation.jsp").forward(request, response);
			
		    
			
			for(int i = 0 ; i < recommendList.getMovieList().size() ; i++){
				//print the highest movie with the score
				System.out.print(recommendList.getMovieList().get(i).getMovieName() + " get ");
				System.out.println(recommendList.getMovieList().get(i).getRating() + " score!");
				 
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
		
}

