package graphic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import object.Player;

public class GameHud {
	private int stage;
	private int score;
	private Player player;
	public static final Font HUD_FONT = Font.loadFont(ClassLoader.getSystemResourceAsStream("PressStart2P.ttf"), 14); 
	
	public GameHud(Player player) {
		this.player=player;
		stage=1;
		score=0;
	}
	
	public void draw(GraphicsContext gc) {
		gc.setFill(Color.WHITE);
		gc.setFont(HUD_FONT);
		gc.fillText("HP :"+player.getHp(), 10, 20);
		gc.fillText("Score :"+score, 200, 20);
		gc.fillText("Stage :"+stage, 500, 20);

	}
	
	public void setStage(int stage) {
		this.stage=stage;
	}
	
	public void addScore(int score) {
		this.score+=score;
	}
	
	public int getScore() {
		return score;
	}
}
