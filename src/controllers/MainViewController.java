package controllers;
import interfaces.FileMediatorInterface;
import interfaces.WebMediatorInterface;

import java.util.ArrayList;
import java.util.List;

import mediators.FileMediator;
import mediators.WebMediator;
import business.MyMovie;

public class MainViewController {
	
	private FileMediatorInterface fileMediator;
	private WebMediatorInterface webMediator;
	
	public MainViewController(FileMediatorInterface fileMediator, WebMediatorInterface webMediator) {
		this.fileMediator = fileMediator;
		this.webMediator = webMediator;
	}
	
	public MainViewController() {
		this.fileMediator = new FileMediator();
		this.webMediator = new WebMediator();
	}
	
	public void addMovieAsFavorite(MyMovie movie){
		fileMediator.storeMovieAsFavorite(movie);
	}
	
	public List<String> getFavoriteMovies(){
		return fileMediator.getFavoriteIds();
	}

	public ArrayList<MyMovie> getBoxOfficeMovies() {
		return webMediator.getBoxOfficeMovies(50);
	}
}
