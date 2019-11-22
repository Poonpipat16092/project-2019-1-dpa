package Object;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Player extends GameObject {
	
	public Player(int x,int y,ID id) {
		super(x,y,id);
		velX=5;
		velY=5;
	}
	
	@Override
	public void tick() {
		x+=velX;
		y+=velY;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.setFill(Color.WHITE);
		gc.fillOval(x, y, 20, 20);
	}

}
