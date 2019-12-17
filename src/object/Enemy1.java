package object;

import graphic.ImageLoader;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Enemy1 extends BattleshipObject {
	
	public Enemy1(ObjectHandler handler) {
		super(random.nextInt(800),random.nextInt(200)-300,ID.Enemy,handler,50,50);
		setDamage(1);
		setScore(1);
		setSpeed();
		hp=1;
		limitX=800;
		limitY=700;
		handler.addObject(this);
	}

	@Override
	public void tick() {
		//remove this when out of frame
		if(!isShow) return;
		x+=velX;
		y+=velY;
		//out of frame
		checkShow();
		collision();
	}

	@Override
	public void draw(GraphicsContext gc) {

		if(!isShow) return;
//		gc.setFill(Color.RED);
//		gc.fillRect(x, y, width, height);
		gc.drawImage(ImageLoader.ENEMY1, x, y);

	}
	
	public void collision() {
		//when being hit //can minimize round with getZ to only check some Z
		for(GameObject temp:handler.getObjects()) {
			if(temp.getId()==ID.Player) {
				if(getBounds().intersects(temp.getBounds().getBoundsInLocal()) && temp.isShow){
					temp.getHit(this);
					getHit(temp);
				}
			}
		}
		
	}
		
	public void checkShow() {
		if(hp<=0) setShow(false);
		if(x<-50 || x>limitX) {
			this.setShow(false);
			return;
		}
		if(y>limitY) {
			this.setShow(false);
			return;
		}
	}
	
	public void setSpeed() {
		if(x>=400) {
			velX=random.nextInt(2)-4;
		}
		else {
			velX=random.nextInt(4);
		}
		velY=8;
	}
		
	public int getZ() {
		return 0;
	}
}
