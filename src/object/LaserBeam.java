package object;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class LaserBeam extends BulletObject {
	public static final int width=100;
	public static final int height=700;
	private Boss boss;
	private int timer;
	//public static final Image image=	
	
	public LaserBeam(Boss boss,ObjectHandler handler) {
		super(boss.getX()+boss.width/2-width/2,boss.getY()+boss.height, ID.Boss, handler);
		this.boss=boss;
		setDamage(boss.getDamage());
		timer=0;
		limitY=700;
		limitX=900;
		handler.addObject(this);
	}
	
	@Override
	public void tick() {
		if(!isShow) return;
		if(timer>=200) {
			isShow=false;
		}
		x=boss.getX()+boss.width/2-width/2;
		y=boss.getY()+boss.height;
		timer++;
	}

	@Override
	public void draw(GraphicsContext gc) {
		if(!isShow) return;
		gc.setFill(Color.YELLOW);
		gc.fillRect(x, y, width, height);
	}

	@Override
	public int getZ() {
		return 5;
	}

	@Override
	public Rectangle getBounds() {
		Rectangle rectangle=new Rectangle(x,y,width,height);
		return rectangle;
	}
	
	public void getHit(int damage) {
		checkShow();
	}
		
	public void checkShow() {

	}
}
