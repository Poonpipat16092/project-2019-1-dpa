package object;

import java.util.Random;

import graphic.ImageLoader;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Enemy2 extends BattleshipObject {
	private int gunTimer=0;
	
	public Enemy2(ObjectHandler handler) {
		super(random.nextInt(800-61),random.nextInt(200)-400,ID.Enemy,handler,60,90);
		setDamage(1);
		setScore(50);
		hp=2;
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
		setSpeed();
		x+=velX;
		y+=velY;
		if(x<=0) x=0;
		if(x>=limitX-width) x=limitX-width;
		if(y>=limitY) y=limitY;
		shooting();
		collision();
		gunTimer++;
	}

	public void collision() {
		for(GameObject temp:handler.getObjects()) {
			if(temp.getId()==ID.Player) {
				if(getBounds().intersects(temp.getBounds().getBoundsInLocal()) && temp.isShow){
					temp.getHit(this);
					getHit(temp);
				}
			}
		}
	}
	
	public void shooting() {
		if(!isShow) return;
		if(gunTimer%75==10) new Bullet(x+width/2, y+height,0,7, getId(), getDamage(), handler);
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		if(!isShow) return;
//		gc.setFill(Color.BLUE);
//		gc.fillRect(x, y, width, height);
		gc.drawImage(ImageLoader.ENEMY2, x, y);
	}

	@Override
	public int getZ() {
		return 0;
	}

		
	public void setSpeed() {
		if(x>=limitX-width || x<=0) velX*=-1; 
		if(y>=limitY) {
			y=limitY;
			velY=0;
		}
	}



}
