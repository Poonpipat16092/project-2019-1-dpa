package object;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Bullet extends GameObject {
	public static final int width=4;
	public static final int heigth=10;
	public static final Image playerLaser=new Image("laserGreen.png",width,heigth,true,true);
	public static final Image enemyLaser=new Image("laserRed.png",width,heigth,true,true);
	
	
	public Bullet(double x,double y,ID id,int damage,ObjectHandler handler) {
		super(x, y, id, handler);
		setDamage(damage);
		limitY=700;
		limitX=900;
		setVel();
		this.damage=1;
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
		if(id==ID.Player) gc.setFill(Color.AZURE);
		if(id==ID.Enemy) gc.setFill(Color.RED);
		gc.fillRect(x, y, width, heigth);
	}

	@Override
	public int getZ() {
		return 1;
	}

	@Override
	public Shape getBounds() {
		Rectangle rect=new Rectangle(x,y,width,heigth);
		return rect;
	}
	
	public void getHit(int damage) {
		checkShow();
	}
	
	public int getDamage() {
		return damage;
	}
	
	public void setVel() {
		if(id==ID.Player) {
			velX=0;
			velY=-7;
		}
		if(id==ID.Enemy) {
			velX=0;
			velY=7;
		}
	}
	
	public void checkShow() {
		setShow(false);
	}
}
