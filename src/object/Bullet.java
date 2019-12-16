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
		setVel(velX,velY);
		setDamage(damage);;
		handler.addObject(this);
	}
	
	@Override
	public void tick() {
		if(!isShow) return;
		if(y<0 || y>limitY) {
			this.setShow(false);
			return;
		}
		if(x<0 || x>limitX) {
			this.setShow(false);
			return;
		}
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

	@Override
	public Rectangle getBounds() {
		Rectangle rect=new Rectangle(x,y,width,height);
		return rect;
	}
	
	public void getHit(GameObject object) {
		checkShow();
	}
		
	public void setVel(int velX,int velY) {
		this.velX=velX;
		this.velY=velY;
	}
	
	public void checkShow() {
		setShow(false);
	}
}
