package graphic;

import javafx.scene.canvas.GraphicsContext;

public interface Screen {
	
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600 ; 
	public abstract void draw(GraphicsContext gc);
	public abstract void startAnimation();
	
}
