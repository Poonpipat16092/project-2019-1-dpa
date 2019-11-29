package Object;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Player extends GameObject {
	// TODO Auto-generated constructor stub

	public Player(int x,int y,ID id) {
		super(x,y,id);
		velX=0;
		velY=0;
		limitX=800;
		limitY=600;
	}
	
	@Override
	public void tick() {
		x+=velX;
		y+=velY;
		// find the limit of scene(edit this when got fix size)
		if(x<=0) x=0;
		if(x>=limitX-20) x=limitX-20;
		if(y<=0) y=0;
		if(y>=limitY-40) y=limitY-40;	
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.setFill(Color.WHITE);
		gc.fillOval(x, y, 20, 20);
	}

}
