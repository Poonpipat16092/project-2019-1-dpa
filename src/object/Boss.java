package object;

import java.util.Random;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Boss extends GameObject {
	public static final int width=400;
	public static final int height=100;
	private int hp;
	public int selfTimer=0;
	public Boss(ObjectHandler handler) {
		super(200,-100,ID.Enemy,handler);
		setDamage(2);
		setScore(10000);
		hp=1000;
		setupSpeed();
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
		setupSpeed();
		shooting();
		collision();
		selfTimer++;
	}

	public void collision() {
		//when being hit //can minimize round with getZ to only check some Z
		for(GameObject temp:handler.getObjects()) {
			if(temp.getId()==ID.Player) {
				if(getBounds().intersects(temp.getBounds().getBoundsInLocal()) && temp.isShow){
					temp.getHit(getDamage());
					getHit(temp.getDamage());
				}
			}
		}
	}
	
	public void shooting() {
		if(!isShow) return;
		if(selfTimer%100==10) new Bullet(x+width/2, y+height, getId(), getDamage(), handler);
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		if(!isShow) return;
		gc.setFill(Color.ROYALBLUE);
		gc.fillRect(x, y, width, height);
	}

	public void setupSpeed() {
		if(y<limitY) {
			velY=2;
			velX=0;
			return;
		}
		if(y>=limitY && velY==2 && velX==0) {
			velY=0;
			velX=2;
			return;
		}
		if(x<=0 || x>=400) {
			velX*=-1;
		}
		
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
	public void getHit(int damage) {
		hp-=damage;
		checkShow();
	}

	@Override
	public void checkShow() {
		if(hp<=0) setShow(false);
	}

}
