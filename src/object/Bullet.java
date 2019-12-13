package object;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Bullet extends GameObject {
	private int damage;
	public static final int width=1;
	public static final int heigth=10;
	
	public Bullet(int x,int y,ID id,int damage,ObjectHandler handler) {
		super(x, y, id, handler);
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
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public Shape getBounds() {
		// TODO Auto-generated method stub
		Rectangle rect=new Rectangle(x,y,width,heigth);
		return rect;
	}
	
	public void getAttack() {
		checkShow();
	}
	
	public int getDamage() {
		return damage;
	}
	
	public void setVel() {
		if(id==ID.Player) {
			velX=0;
			velY=-5;
		}
		if(id==ID.Enemy) {
			velX=0;
			velY=5;
		}
	}
	
	public void checkShow() {
		setShow(false);
	}
}
