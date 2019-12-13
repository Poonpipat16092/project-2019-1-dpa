package object;

import java.util.List;
import java.util.Random;

import graphic.GameScreen;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Shape;

public abstract class GameObject {
	
	protected double x,y;//location
	protected int velX,velY;//speed per frame
	protected int damage;
	protected ID id;
	protected int limitX;
	protected int limitY;
	protected ObjectHandler handler;
	protected boolean isShow;
	protected int score=0;
	public static Random random=new Random();
	
	public GameObject(double x,double y,ID id,ObjectHandler handler) {
		this.x=x;
		this.y=y;
		this.id=id;
		this.handler=handler;
		this.isShow=true;
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

	public abstract void tick();
	public abstract void draw(GraphicsContext gc);
	public abstract int getZ();
	public abstract Shape getBounds();

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	public boolean isShow() {
		return isShow;
	}

	public void setShow(boolean isShow) {
		this.isShow = isShow;
	}
	
	public Random getRandom() {
		return random;
	}
	
	public void setScore(int score) {
		this.score=score;
	}
	
	public int getScore() {
		return score;
	}
		


	public abstract void getHit(int damage);
	
	public abstract void checkShow();

}
