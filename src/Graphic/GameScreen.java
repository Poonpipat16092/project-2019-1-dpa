package Graphic;

import Object.ID;
import Object.ObjectHandler;
import Object.Player;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GameScreen implements Screen {
	private Stage primarystage;
	private Canvas canvas;
	private GraphicsContext gc;
	private Pane root;
	private AnimationTimer timer;
	private ObjectHandler handler;
	
	public GameScreen(Stage Primarystage) {
		primarystage=Primarystage;
		canvas=new Canvas(WIDTH,HEIGHT);
		gc=canvas.getGraphicsContext2D();
		
		//test handler
		handler =new ObjectHandler();
		handler.addObject(new Player(100,100,ID.Player));
		
		
		root=new Pane();
		root.setPrefSize(WIDTH, HEIGHT);
		root.getChildren().add(canvas);
		canvas.requestFocus();
		
		//setSound
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, WIDTH, HEIGHT);

		timer=new AnimationTimer() {
			@Override
			public void handle(long arg0) {
				//reset background
				gc.setFill(Color.BLACK);
				gc.fillRect(0, 0, WIDTH, HEIGHT);
				//handler with object
				handler.tick();
				handler.draw(gc);
			}
		};

		Scene scene=new Scene(root);
		primarystage.setScene(scene);
		
		timer.start();

	}

	@Override
	public void startanimation() {
		draw(gc);
	}

}
