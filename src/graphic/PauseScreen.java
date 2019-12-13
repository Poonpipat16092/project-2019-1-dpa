package graphic;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import object.ObjectHandler;

public class PauseScreen implements Screen {
	
	private Stage primarystage;
	private Canvas canvas;
	private GraphicsContext gc;
	private Pane root;
	private AnimationTimer timer;
	private ObjectHandler handler;

	public PauseScreen() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated meth

	}

	@Override
	public void startAnimation() {
		// TODO Auto-generated method stub

	}

}
