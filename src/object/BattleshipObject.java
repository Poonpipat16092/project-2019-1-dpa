package object;

import graphic.GameScreen;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Shape;

public abstract class BattleshipObject extends GameObject implements Damagable {
	protected int damage;
	protected int score=0;
	private int hp;

	
	public BattleshipObject(double x,double y,ID id,ObjectHandler handler) {
		super(x,y,id,handler);
		
	}
	
	public double cos() {
		double kam=GameScreen.getPlayer().getY()-y;
		double chid=GameScreen.getPlayer().getX()-x;
		double chack=Math.sqrt((kam*kam)+(chid*chid));
		double cos=chid/chack;
		return cos;
	}
	
	public double sin() {
		double kam=GameScreen.getPlayer().getY()-y;
		double chid=GameScreen.getPlayer().getX()-x;
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