package application;

import graphic.AudioLoader;
import graphic.EndScreen;
import graphic.ImageLoader;
import graphic.StartScreen;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import graphic.SelectPlayerScreen;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primarystage) throws Exception {
		StartScreen startScreen = new StartScreen(primarystage);
		startScreen.startAnimation();
		primarystage.show();
	}

}
