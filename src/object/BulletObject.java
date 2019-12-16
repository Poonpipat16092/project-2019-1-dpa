package object;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Shape;

public abstract class BulletObject extends GameObject implements Damagable{
	private int damage;

	public BulletObject(double x,double y,ID id,ObjectHandler handler) {
		super(x,y,id,handler);
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
	public abstract Shape getBounds();
	public abstract void checkShow();

}
