package graphic;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GameOverScreen implements Screen {
	private int score ;
	private Canvas canvas;
	private Stage primarystage ;
	private GraphicsContext gc;
	private Pane root;
	private static final Font mainFont = new Font("supermarket.ttf", 24);
	private static final Font GAME_OVER_FONT = new Font("supermarket.ttf", 24);
//	private static final Image GAME_OVER_SENCE = new Image("");
	
	public GameOverScreen(Stage Primarystage,int score) {
		canvas=new Canvas(WIDTH,HEIGHT);
		this.score=score;
		gc=canvas.getGraphicsContext2D();
		setupExit();
		
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
//		gc.drawImage(background, 0, 0);
		//-----temporary backgroud-------//
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, WIDTH, HEIGHT);
		//-------------------------------//
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
	
	public void setupExit() {
		
	}
	
}
