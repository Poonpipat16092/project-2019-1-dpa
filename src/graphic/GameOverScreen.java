package graphic;


import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GameOverScreen implements Screen {
	private int score = 0 ;
	private Stage primarystage ;
	private GraphicsContext gc;
	private Canvas canvas ;
	private static final Font mainFont = new Font("supermarket.ttf", 24);
	private static final Font GAME_OVER_FONT = new Font("supermarket.ttf", 100);
//	private static final Image GAME_OVER_SENCE = new Image("");
	
	public GameOverScreen(Stage primarystage) {
		// TODO Auto-generated constructor stub
		canvas = new Canvas(WIDTH,HEIGHT) ;
		gc = canvas.getGraphicsContext2D();
		
		this.primarystage = primarystage;
		
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
//		gc.drawImage(background, 0, 0);
		//temporary backgroud
		Pane root = new Pane();
		root.setPrefSize(WIDTH, HEIGHT);
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, WIDTH, HEIGHT);
		
		//GAMEOVER 
		gc.setFont(GAME_OVER_FONT);
		gc.setFill(Color.WHITE);
		gc.setLineWidth(2);
		gc.fillText("GAME OVER !", 100, 100);
		//Press Enter
		gc.setFont(mainFont);
		gc.setFill(Color.AQUAMARINE);
		gc.fillText("Press ENTER ", 350, 400);
		//Score 
		gc.setFill(Color.WHITE);
		gc.fillText("SCORE : " + score, 350, 150);
		
		root.getChildren().add(canvas);
		Scene scene = new Scene(root);
		scene.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent key) {
				// TODO Auto-generated method stub
				if(key.getCode() == KeyCode.ENTER) {
					StartScreen startScreen = new StartScreen(primarystage);
					startScreen.startAnimation();
				}
			}
			
		});
		primarystage.setScene(scene);
	}


	@Override
	public void startAnimation() {
		// TODO Auto-generated method stub
		draw(gc);

	}

}
