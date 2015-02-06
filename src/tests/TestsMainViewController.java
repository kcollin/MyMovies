package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import controllers.MainViewController;
import business.MyMovie;
import interfaces.*;
import it.jtomato.gson.Movie;
import it.jtomato.gson.Review;

public class TestsMainViewController {

	public boolean storeCalled;

	@Test
	public void addMovieAsFavorite_addsMovieAsFavorite() {
		MainViewController controller = new MainViewController(new MockFileMediator(), new MockWebMediator());
		MyMovie movie = new MyMovie(new Movie());
		controller.addMovieAsFavorite(movie);
		assertTrue(storeCalled);
	}
	
	@Test
	public void getFavoriteMovies_getsFavorites() {
		MainViewController controller = new MainViewController(new MockFileMediator(), new MockWebMediator());
		List<String> favoriteMovies = controller.getFavoriteMovies();
		assertEquals("123", favoriteMovies.get(0));
	}
	
	@Test
	public void getBoxOfficeMovies_getsMovies() {
		MainViewController controller = new MainViewController(new MockFileMediator(), new MockWebMediator());
		ArrayList<MyMovie> boxOfficeMovies = controller.getBoxOfficeMovies();
		assertEquals(1, boxOfficeMovies.size());
	}
	
	class MockWebMediator implements WebMediatorInterface{

		@Override
		public ArrayList<MyMovie> getBoxOfficeMovies(int limit) {
			ArrayList<MyMovie> movies = new ArrayList<MyMovie>();
			movies.add(new MyMovie(new Movie()));
			return movies;
		}

		@Override
		public ArrayList<MyMovie> searchMovie(String searchString) {
			return null;
		}

		@Override
		public Movie getAdditionalInfo(Movie movie) {
			return null;
		}

		@Override
		public List<Review> getReviews(Movie movie) {
			return null;
		}
		
	}
	
	class MockFileMediator implements FileMediatorInterface{

		@Override
		public void storeMovieAsFavorite(MyMovie movie) {
			storeCalled = true;
		}

		@Override
		public List<String> getFavoriteIds() {
			return Arrays.asList("123");
		}
		
	}

}
