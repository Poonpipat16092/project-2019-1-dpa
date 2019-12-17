package object;

import graphic.GameScreen;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Shape;

public abstract class BattleshipObject extends GameObject implements Damagable {
	protected int damage;
	protected int hp;
	
	public abstract void collision();
	
	@Override
	public void getHit(GameObject object) {
		if(object instanceof Damagable) hp-=((Damagable) object).getDamage();
		checkShow();
	}

	
	public BattleshipObject(double x,double y,ID id,ObjectHandler handler,int width,int height) {
		super(x,y,id,handler,width,height);
		this.width=width;
		this.height=height;
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
	
	@Override
	public void checkShow() {
		if(hp<=0) setShow(false);
	}
	
	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
	

}
