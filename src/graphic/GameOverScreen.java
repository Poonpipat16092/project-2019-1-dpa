package graphic;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GameOverScreen implements Screen {
	private int score ;
	private Stage primarystage ;
	private GraphicsContext gc;
	private static final Font mainFont = new Font("supermarket.ttf", 24);
	private static final Font GAME_OVER_FONT = new Font("supermarket.ttf", 24);
//	private static final Image GAME_OVER_SENCE = new Image("");
	
	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
//		gc.drawImage(background, 0, 0);
		gc.setFont(GAME_OVER_FONT);
		gc.setFill(Color.WHITE);
		gc.setLineWidth(2);
		gc.fillText("GAME OVER!", 150, 100);
		gc.setFont(mainFont);
//		gc.fillText("SCORE : " + score, 300, 150);
	}


	@Override
	public void startAnimation() {
		// TODO Auto-generated method stub
		draw(gc);

	}

}
