package object;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Shape;

public abstract class BulletObject extends GameObject implements Damagable{
	private int damage;

	public BulletObject(double x,double y,ID id,ObjectHandler handler,int width,int height) {
		super(x,y,id,handler,width,height);
	}
	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	
	public abstract void tick();
	public abstract void draw(GraphicsContext gc);
	public abstract int getZ();
	public abstract void checkShow();

}
