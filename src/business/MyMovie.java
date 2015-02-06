package business;

import interfaces.WebMediatorInterface;
import it.jtomato.gson.Movie;
import it.jtomato.gson.Review;
import java.util.List;

import mediators.WebMediator;

public class MyMovie {
	
	private Movie movie;
	private List<Review> reviews;
	private WebMediatorInterface webMediator = new WebMediator();
	
	public MyMovie(Movie movie) {
		this.movie = movie;		
	}
	
	public MyMovie(Movie movie, WebMediatorInterface mediator) {
		this(movie);
		webMediator = mediator;
	}

	public Movie getInnerMovie() {
		return this.movie;
	}
	
	public String getTitle(){
		return this.movie.title;
	}
	
	public String getId(){
		return this.movie.id;
	}
	
	public int getRating(){
		return this.movie.rating.audienceScore;		
	}

	public String getSynopsis() {
		return this.movie.synopsis;
	}

	public List<String> getGenres() {
		if (this.movie.genres == null){
			this.movie = webMediator.getAdditionalInfo(this.movie);
		}
		
		return this.movie.genres;
	}
	
	public List<Review> getReviews(){
		if (this.reviews == null){
			this.reviews = webMediator.getReviews(this.movie);
		}
		
		return this.reviews;
	}
	
	@Override
	public String toString(){
		return movie.title;
	}
}
