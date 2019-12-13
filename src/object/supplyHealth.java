package object;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class supplyHealth extends GameObject {
	public static final int width=20;
	public static final int height=20;
	
	public supplyHealth(ObjectHandler handler){
		super(random.nextInt(800),random.nextInt(200)-400,ID.Supply,handler);
		velX=0;
		velY=2;
		limitX=800;
		limitY=700;
		handler.addObject(this);
	}

	@Override
	public void tick() {
		checkShow();
		if(isShow()==false) return;
		y+=velY;
		collosion();
	}

	@Override
	public void draw(GraphicsContext gc) {
		if(!isShow) return;
		gc.setFill(Color.PINK);
		gc.fillRect(x, y, width, height);
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public Shape getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getAttack() {
		// TODO Auto-generated method stub

	}

	@Override
	public void checkShow() {
		// TODO Auto-generated method stub

	}

}
