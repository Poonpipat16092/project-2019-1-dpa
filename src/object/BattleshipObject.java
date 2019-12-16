package object;

import graphic.EndScreen;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Shape;

public abstract class BattleshipObject extends GameObject implements Damagable {
	protected int damage;
	protected int score=0;
	private int hp;
	
	public abstract void collision();
	
	public BattleshipObject(double x,double y,ID id,ObjectHandler handler,int width,int height) {
		super(x,y,id,handler,width,height);
		this.width=width;
		this.height=height;
	}
	
	public double cos() {
		double kam=EndScreen.getPlayer().getY()-y;
		double chid=EndScreen.getPlayer().getX()-x;
		double chack=Math.sqrt((kam*kam)+(chid*chid));
		double cos=chid/chack;
		return cos;
	}
	
	public double sin() {
		double kam=EndScreen.getPlayer().getY()-y;
		double chid=EndScreen.getPlayer().getX()-x;
		double chack=Math.sqrt((kam*kam)+(chid*chid));
		double sin=kam/chack;
		return sin;
	}
	
	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

}
