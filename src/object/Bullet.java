package object;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Bullet extends BulletObject {
	public static final int width=10;
	public static final int heigth=20;
	public static final Image playerLaser=new Image("laserBlue02.png",width,heigth,true,true);
	public static final Image playerLaser2=new Image("laserGreen.png",width,heigth,true,true);
	public static final Image enemyLaser=new Image("laserRed.png",width,heigth,true,true);
	
	
	public Bullet(double x,double y,int velX,int velY,ID id,int damage,ObjectHandler handler) {
		super(x, y, id, handler);
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
				gc.drawImage(playerLaser2, x, y);
			}
			else gc.drawImage(playerLaser, x, y);
		}
		if(id==ID.Enemy||id==ID.Boss) {
			gc.drawImage(enemyLaser, x, y);
		}
	}

	@Override
	public int getZ() {
		return 1;
	}

	@Override
	public Rectangle getBounds() {
		Rectangle rect=new Rectangle(x,y,width,heigth);
		return rect;
	}
	
	public void getHit(int damage) {
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
