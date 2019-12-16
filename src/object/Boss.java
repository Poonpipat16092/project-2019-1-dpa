package object;

import java.util.Random;

import graphic.AudioLoader;
import graphic.ImageLoader;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Boss extends BattleshipObject {
	private boolean timerStart=false;
	private boolean ultimate=false;
	public int selfTimer=0;
	
	public Boss(ObjectHandler handler) {
		super(200,-100,ID.Boss,handler,400,100);
		setDamage(2);
		setScore(10000);
		hp=300;
		setupSpeed();
		limitX=800;
		limitY=0;
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
		if(timerStart) selfTimer++;
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
		if(selfTimer>=1200) {
			ultimate=false;
			selfTimer=0;
		}
		if(ultimate==true && selfTimer%20==10) {
//			new BossBullet(x+width/3, y+height, getDamage(), handler,0);
//			new BossBullet(x+width/3*2, y+height, getDamage(), handler,0);
//			new BossBullet(x+width/3, y+height, getDamage(), handler,1);
//			new BossBullet(x+width/3*2, y+height, getDamage(), handler,-1);
			new Bullet(x+width/6, y+height, 0, 10, id,getDamage(), handler);
 			new Bullet(x+width/3, y+height, 0, 10, id, getDamage(), handler);
			new Bullet(x+width/6*5, y+height, 0, 10, id, getDamage(), handler);
			new Bullet(x+width/3*2, y+height, 0, 10, id, getDamage(), handler);
			return;
		}
		if(ultimate==true) return;
		if(selfTimer>=1000) {
			ultimate=true;
			AudioLoader.MEGA_LASER.play();
			new LaserBeam(this,handler);
			return;
		}
		if(selfTimer%80==10) {
			new BossBullet(x+width/2, y+height, getDamage(), handler,0);
			new BossBullet(x+width/2, y+height, getDamage(), handler,1);
			new BossBullet(x+width/2, y+height, getDamage(), handler,2);
			return;
		}
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		if(!isShow) return;
		if(!ultimate && selfTimer>=800) {
			gc.drawImage(ImageLoader.BOSS_CHARGING, x+width/2-30, y+height);
			gc.drawImage(ImageLoader.BOSS_CHARGING, x+width/2+10, y+height);
		}
		gc.drawImage(ImageLoader.BOSS, x, y);
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
			timerStart=true;
			return;
		}
		if(x<=0 || x>=400) {
			velX*=-1;
		}
		
	}
	
	@Override
	public int getZ() {
		return -1;
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x,y,width,height);
	}

	@Override
	public void getHit(GameObject object) {
		if(object instanceof Damagable) hp-=((Damagable) object).getDamage();
		checkShow();
	}

	@Override
	public void checkShow() {
		if(hp<=0) setShow(false);
	}

}
