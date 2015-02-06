package client;

import java.awt.List;
import java.util.ArrayList;

import com.sun.javafx.collections.ObservableListWrapper;

import business.MyMovie;
import mediators.FileMediator;
import controllers.MainViewController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MyMoviesApplication extends Application{

	MainViewController controller = new MainViewController();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		ListView<MyMovie> moviesListView = new ListView<MyMovie>();		
		ArrayList<MyMovie> boxOfficeMovies = controller.getBoxOfficeMovies();
		ObservableListWrapper<MyMovie> observableMovies = new ObservableListWrapper<MyMovie>(boxOfficeMovies);
		moviesListView.setItems(observableMovies);
		StackPane pane = new StackPane(moviesListView);
		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args){
		launch(args);
	}

}
