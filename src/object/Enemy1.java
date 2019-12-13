package object;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Enemy1 extends GameObject {
	public static final int width=30;
	public static final int height=30;
	public Enemy1(int x, int y,ObjectHandler handler) {
		super(x,y,ID.Enemy,handler);
		hp=1;
		velX=3;
		velY=1;
		limitX=800;
		limitY=700;
		handler.addObject(this);
	}

	@Override
	public void tick() {
		//remove this when out of frame
		checkShow();
		if(!isShow) return;
		x+=velX;
		y+=velY;
		if(x<0) x=0;
		if(x>limitX) x=limitX;
		if(x>=limitX || x<=0) velX*=-1; 
		//out of frame
		if(y>limitY) setShow(false);
		collision();
	}

	@Override
	public void draw(GraphicsContext gc) {

		if(!isShow) return;
		gc.setFill(Color.RED);
		gc.fillRect(x, y, width, height);

	}
	
	public void collision() {
		//when being hit //can minimize round with getZ to only check some Z
		for(GameObject temp:handler.getObjects()) {
			if(temp.getId()==ID.Player) {
				if(getBounds().intersects(temp.getBounds().getBoundsInLocal()) && temp.isShow){
					temp.getAttack();
					getAttack();
				}
			}
		}
		
	}
	
	public void getAttack() {
		hp--;
		checkShow();
	}
	
	public void checkShow() {
		if(hp<=0) setShow(false);
		if(y<0 || y>limitY) {
			this.setShow(false);
			return;
		}
		if(x<0 || x>limitX) {
			this.setShow(false);
			return;
		}

	}
	
	public Shape getBounds() {
		return new Rectangle(x,y,width,height);
	}
	
	public int getZ() {
		return 0;
	}
}
