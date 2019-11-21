package Graphic;

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
	
	public GameScreen(Stage Primarystage) {
		primarystage=Primarystage;
		canvas=new Canvas(WIDTH,HEIGHT);
		gc=canvas.getGraphicsContext2D();
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		Pane root=new Pane();
		root.setPrefSize(WIDTH, HEIGHT);
		root.getChildren().add(canvas);
		canvas.requestFocus();
		
		//draw blue screen
		gc.setFill(Color.BLUE);
		gc.fillRect(0, 0, WIDTH, HEIGHT);
		
		Scene scene=new Scene(root);
		primarystage.setScene(scene);
		

	}

	@Override
	public void startanimation() {
		draw(gc);
	}

}
