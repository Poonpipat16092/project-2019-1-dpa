package object;


import graphic.ImageLoader;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Bullet extends BulletObject {
	
	public Bullet(double x,double y,int velX,int velY,ID id,int damage,ObjectHandler handler) {
		super(x, y, id, handler,10,20);
		setDamage(damage);
		limitY=700;
		limitX=900;
		setVelX(velX);
		setVelY(velY);
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
		if(id==ID.Player) {
			if(getDamage()==2) {
				gc.drawImage(ImageLoader.PLAYER_LASER, x, y);
			}
			else gc.drawImage(ImageLoader.PLAYER_LASER2, x, y);
		}
		if(id==ID.Enemy||id==ID.Boss) {
			gc.drawImage(ImageLoader.ENEMY_LASER, x, y);
		}
	}

	@Override
	public int getZ() {
		return 1;
	}

	
	
	public void getHit(GameObject object) {
		setShow(false);
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
