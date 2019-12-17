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
import graphic.ImageLoader;

public class EndScreen implements Screen {
	private int score = 0 ;
	private Stage primarystage ;
	private GraphicsContext gc;
	private Canvas canvas ;
	private boolean isWin ;
	
	public EndScreen(Stage primarystage,boolean iswin) {
		// TODO Auto-generated constructor stub
		canvas = new Canvas(WIDTH,HEIGHT) ;
		gc = canvas.getGraphicsContext2D();
		this.isWin = iswin ;
		this.score=GameScreen.getHud().getScore();
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
		
		gc.setFont(HEADER_FONT);
		gc.setFill(Color.WHITE);
		gc.setLineWidth(2);
		if(isWin) {
			gc.fillText("WINNER!", 300, 100);
			gc.drawImage(ImageLoader.WINNER_CUP, 300, 180);
		}
		else {
			gc.fillText("GAME OVER!", 250, 100);
			gc.drawImage(ImageLoader.BOOM, 300, 180);
		}
		//Press Enter
		gc.setFont(MAIN_FONT);
		gc.setFill(Color.AQUAMARINE);
		gc.fillText("Press ENTER ", 310, 410);
		//Score 
		gc.setFill(Color.WHITE);
		gc.fillText("SCORE : " + score, 300, 150);
		
		
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