package Application;

import Graphic.StartScreen;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends  Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primarystage) throws Exception {
		// TODO Auto-generated method stub
		StartScreen startScreen = new StartScreen(primarystage);
		startScreen.startanimation();
		primarystage.show();
	}

}
