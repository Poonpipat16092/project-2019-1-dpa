package object;

import graphic.ImageLoader;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class LaserBeam extends BulletObject {
	private Boss boss;
	private int timer;
	
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
		checkShow();
		x=boss.getX()+boss.width/2-width/2;
		y=boss.getY()+boss.height;
		timer++;
	}

	@Override
	public void draw(GraphicsContext gc) {
		if(!isShow) return;
		gc.drawImage(ImageLoader.BOSS_LASERBEAM, x, y);
	}

	@Override
	public int getZ() {
		return 5;
	}

		
	public void getHit(GameObject object) {
		checkShow();
	}
		
	public void checkShow() {
		if(timer>=200) {
			isShow=false;
		}
	}
}
