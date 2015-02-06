package client;

import business.MyMovie;
import controllers.MainViewController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MyMoviesApplication extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		MainViewController controller = setUpViewController();
		
		BorderPane pane = new BorderPane();
		pane.setTop(controller.getMoviesListView());
		pane.setBottom(controller.getGetMoviesButton());
		
		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private MainViewController setUpViewController() {
		MainViewController controller = new MainViewController();
		controller.setMoviesListView(new ListView<MyMovie>());
		controller.setGetMoviesButton(new Button("Get movies"));
		return controller;
	}
	
	public static void main(String[] args){
		launch(args);
	}
}
