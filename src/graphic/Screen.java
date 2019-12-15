package graphic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.text.Font;

public interface Screen {
	
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600 ; 
	
	public static final Font mainFont = Font.loadFont(ClassLoader.getSystemResourceAsStream("PressStart2P.ttf"), 16);
	public static final Font HEADER_FONT = Font.loadFont(ClassLoader.getSystemResourceAsStream("PressStart2P.ttf"), 30);
	public static final Font NORMAL = Font.loadFont(ClassLoader.getSystemResourceAsStream("PressStart2P.ttf"), 20);
	public static final Image BOOM = new Image("Boom.png",200,200,true,true);
	public static final Image START_SCREEN = new Image("startScreen.jpg",WIDTH,HEIGHT,false,true);
	public static final Image Player1 = new Image("player1.png",100,100,true,true);
	public static final Image Player2 = new Image("player2.png",100,100,true,true);
	public abstract void draw(GraphicsContext gc);
	public abstract void startAnimation();
	
}
