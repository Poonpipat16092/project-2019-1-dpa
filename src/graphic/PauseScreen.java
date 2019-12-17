package graphic;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import object.ObjectHandler;

public class PauseScreen  {
	public static final Font PAUSE_FONT = Font.loadFont(ClassLoader.getSystemResourceAsStream("supermarket.ttf"), 50);
	
	public static void draw(GraphicsContext gc) {
	
		gc.setFill(Color.rgb(192, 192, 192, 0.5));
		gc.fillRect(0, 0, 800,600);
		
		gc.setFill(Color.ANTIQUEWHITE);
		gc.setFont(PAUSE_FONT);
		gc.fillText("Pause", 200, 200);
		
		
		gc.setFill(Color.ANTIQUEWHITE);
		gc.setFont(PAUSE_FONT);
		gc.fillText("Press Space to continue", 200, 400);
		
	}


}
