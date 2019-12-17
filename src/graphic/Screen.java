package graphic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.text.Font;

public interface Screen {
	
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600 ; 

	public static final Font MAIN_FONT = Font.loadFont(ClassLoader.getSystemResourceAsStream("PressStart2P.ttf"), 16);
	public static final Font HEADER_FONT = Font.loadFont(ClassLoader.getSystemResourceAsStream("PressStart2P.ttf"), 30);
	public static final Font SELECT_PLAYER = Font.loadFont(ClassLoader.getSystemResourceAsStream("PressStart2P.ttf"), 20);

	
	public abstract void draw(GraphicsContext gc);
	public abstract void startAnimation();
	
}
