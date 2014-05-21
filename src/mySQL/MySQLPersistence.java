package mySQL;

import java.sql.*;

import controller.*;


public class MySQLPersistence {

	public Connection connection = null;

	public MySQLPersistence() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		}
		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/movierecommendation", "root", "123456");

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
	}

	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public MovieList getAllMovie() throws SQLException{
		MovieList movieList = new MovieList();
		
		int i;
		
		try{
			Statement st = connection.createStatement();
			String query = "select count(MovieID) as countMovie from movie";			
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()){
				int countMovie = rs.getInt(1);
				
				for(i = 1; i<=countMovie ; i++){
					Movie movie = new Movie();
					
					String movieDetails = "select MovieID, MovieName, IMDBrating, MovieYear, MovieDesc "
							+ "from movie where MovieID =" + i;
					Statement st1 = connection.createStatement();
					ResultSet rs1 = st1.executeQuery(movieDetails);
					
					while(rs1.next()){
						movie.setMovieID(rs1.getInt(1));
						movie.setMovieName(rs1.getString(2));
						movie.setImdbRating(rs1.getInt(3));
						movie.setYear(rs1.getInt(4));
						movie.setDescription(rs1.getString(5));
					}
					
					String movieDirector = "SELECT d.DirectorID, CONCAT(d.DirectorName, ' ' , d.DirectorLastName) AS DirectorName "
							+ "FROM director d ,moviedirector md "
							+ "where d.directorID = md.directorID "
							+ "and md.movieID=" + i;
					ResultSet rs2 = st1.executeQuery(movieDirector);
					
					while(rs2.next()){
						movie.getDirector().setDirectorId(rs2.getInt(1));
						movie.getDirector().setDirectorName(rs2.getString(2));
					}
					
					String movieStars = "select s.StarsID , CONCAT(s.StarsName, ' ' , s.StarsLastName)  "
							+ "from moviestars ms , stars s "
							+ "where ms.StarsID=s.StarsID and ms.MovieID=" + i;
					ResultSet rs3 = st1.executeQuery(movieStars);
					
					while(rs3.next()){
						Stars tempStar = new Stars();
						tempStar.setStarID(rs3.getInt(1));
						tempStar.setStarName(rs3.getString(2));
						movie.getStar().getStarsList().add(tempStar);
					}
					
					String movieGenre = "select g.GenreID,g.GenreName from genre g, moviegenre mg "
							+ "where g.GenreID=mg.GenreID and mg.MovieID=" + i;
					ResultSet rs4 = st1.executeQuery(movieGenre);
					
					while(rs4.next()){
						Genre tempGenre = new Genre();
						tempGenre.setGenreInt(rs4.getInt(1));
						tempGenre.setGenreName(rs4.getString(2));
						movie.getGenre().getGenreList().add(tempGenre);
					}
					
					String movieTag ="select t.tagID , t.tagName from tag t, movietag mt "
							+ "where t.tagID=mt.tagID and mt.MovieID=" + i;
					ResultSet rs5 = st1.executeQuery(movieTag);
					
					while(rs5.next()){
						Tag tempTag = new Tag();
						tempTag.setTagID(rs5.getInt(1));
						tempTag.setTagName(rs5.getString(2));
						movie.getTag().getTagList().add(tempTag);
					}
					
					String movieOrigin ="select o.OriginID , o.OriginName from origin o , movieorigin mo "
							+ "where o.originID = mo.originID and mo.MovieID=" + i;
					ResultSet rs6 = st1.executeQuery(movieOrigin);
					
					while(rs6.next()){
						movie.getOrigin().setOriginID(rs6.getInt(1));
						movie.getOrigin().setOriginName(rs6.getString(2));
					}
					
					movieList.getMovieList().add(movie);
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}			
		
		return movieList;
	}
	
	
}