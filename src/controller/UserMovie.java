package controller;

public class UserMovie {
	
	/*This class using for the collect all information that user want to watch.
	 * in the scenario user has to choice at least genre.However we will suggest to user that
	 * S/He give more information to us to recommend best movie in order to his/her choices.
	 * 
	 * This is not same with our movie class but there is similarly with it,
	 * userMovie will create after he give the parameters.
	 * */
	
	private Genre genre = new Genre();
	private Tag tag = new Tag();
	private Director director = new Director();
	private Origin origin = new Origin();
	private Stars star = new Stars();
	private int imdbRating;
	 
	public UserMovie() {
		super();
	}

	public UserMovie(Genre genre, Tag tag, Director director, Origin origin,
			Stars star, int imdbRating) {
		super();
		this.genre = genre;
		this.tag = tag;
		this.director = director;
		this.origin = origin;
		this.star = star;
		this.imdbRating = imdbRating;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		if(genre != null)
			this.genre = genre;
		else
			throw new NullPointerException("User has to choice at least one genre");
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	public Origin getOrigin() {
		return origin;
	}

	public void setOrigin(Origin origin) {
		this.origin = origin;
	}

	public Stars getStar() {
		return star;
	}

	public void setStar(Stars star) {
		this.star = star;
	}

	public int getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(int imdbRating) {
		this.imdbRating = imdbRating;
	}
	 
	 
	 
	 

}
