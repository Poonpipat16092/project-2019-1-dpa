package object;

import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Enemy2 extends GameObject {
	public static final int width=40;
	public static final int height=40;
	public int selfTimer=0;
	public Enemy2(ObjectHandler handler) {
		super(random.nextInt(800),random.nextInt(200)-400,ID.Enemy,handler);
		hp=1;
		velX=2;
		velY=2;
		limitX=800;
		limitY=100;
		handler.addObject(this);
	}
	
	@Override
	public void tick() {
		checkShow();
		if(!isShow) return;
		x+=velX;
		y+=velY;
		if(x<0) x=0;
		if(x>limitX) x=limitX;
		if(x>=limitX || x<=0) velX*=-1; 
		if(y>limitY) y=limitY;
		shooting();
		collision();
		selfTimer++;
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
	
	public void shooting() {
		if(!isShow) return;
		if(selfTimer%100==10) new Bullet(x+width/2, y+height, getId(), 1, handler);
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		if(!isShow) return;
		gc.setFill(Color.BLUE);
		gc.fillRect(x, y, width, height);
	}

	@Override
	public int getZ() {
		return 0;
	}

	@Override
	public Shape getBounds() {
		return new Rectangle(x,y,width,height);
	}

	@Override
	public void getAttack() {
		hp--;
		checkShow();
	}

	@Override
	public void checkShow() {
		if(hp<=0) setShow(false);
	}

}
