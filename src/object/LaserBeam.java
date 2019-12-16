package object;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class LaserBeam extends BulletObject {
	private Boss boss;
	private int timer;
	public static final Image LASERBEAM=new Image("MeagaLaser.jpg", 100, 700, false, true);
	
	public LaserBeam(Boss boss,ObjectHandler handler) {
		super(boss.getX()+boss.width/2-50,boss.getY()+boss.height, ID.Boss, handler,100,700);
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
		gc.drawImage(LASERBEAM, x, y);
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
	
	public void getHit(GameObject object) {
		checkShow();
	}
		
	public void checkShow() {

	}
}
