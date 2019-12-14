package application;

import graphic.GameOverScreen;
import graphic.StartScreen;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primarystage) throws Exception {
		StartScreen startScreen = new StartScreen(primarystage);
		startScreen.startAnimation();
//		GameOverScreen end = new GameOverScreen(primarystage);
//		end.startAnimation();
		primarystage.show();
	}

}
