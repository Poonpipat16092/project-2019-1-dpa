package object;


import graphic.ImageLoader;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class BossBullet extends BulletObject {
	private int state;
	
	public BossBullet(double x,double y,int damage,ObjectHandler handler,int state) {
		super(x, y, ID.Boss, handler,20,20);
		setDamage(damage);
		this.state=state;
		limitY=700;
		limitX=900;
		setVel();
		handler.addObject(this);
	}
	
	@Override
	public void tick() {
		if(!isShow) return;
		checkShow();
		x+=velX;
		y+=velY;
	}

	@Override
	public void draw(GraphicsContext gc) {
		if(!isShow) return;
//		gc.setFill(Color.WHITE);
//		gc.fillRect(x, y, width, height);
		gc.drawImage(ImageLoader.BOSS_NORMAL_BULLET, x, y);
	}

	@Override
	public int getZ() {
		return 1;
	}

	public void getHit(GameObject object) {
		setShow(false);
	}
		
	public void setVel() {
		if(state==0) {
			velY=6;
			velX=1;
		}
		if(state==1) {
			velY=7;
		}
		if(state==2) {
			velY=6;
			velX=-1;
		}
		velY=1;
	}
	
	public void checkShow() {
		if(y<0 || y>limitY) {
			this.setShow(false);
			return;
		}
		if(x<0 || x>limitX) {
			this.setShow(false);
			return;
		}

	}
}
