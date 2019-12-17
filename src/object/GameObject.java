package object;

import java.util.List;
import java.util.Random;

import graphic.GameScreen;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public abstract class GameObject {
	
	protected double x,y;//location
	protected double velX,velY;//speed per frame
	protected int width,height;
	protected ID id;
	protected int limitX;
	protected int limitY;
	protected ObjectHandler handler;
	protected boolean isShow;
	protected int score;
	protected static Random random=new Random();
	
	public GameObject(double x,double y,ID id,ObjectHandler handler,int width,int height) {
		this.x=x;
		this.y=y;
		this.id=id;
		this.score=0;
		this.handler=handler;
		this.isShow=true;
		this.width=width;
		this.height=height;
	}
	public abstract void tick();
	public abstract void draw(GraphicsContext gc);
	public abstract int getZ();
	public abstract void getHit(GameObject object);
	public abstract void checkShow();
	
	public Shape getBounds() {
		return new Rectangle(x,y,width,height);
	}
	
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

	public double getVelX() {
		return velX;
	}

	public void setVelX(double velX) {
		this.velX = velX;
	}

	public double getVelY() {
		return velY;
	}

	public void setVelY(double velY) {
		this.velY = velY;
	}

	public ID getId() {
		return id;
	}

	public boolean isShow() {
		return isShow;
	}

	public void setShow(boolean isShow) {
		this.isShow = isShow;
	}
	
	public void setScore(int score) {
		this.score=score;
	}
	
	public int getScore() {
		return score;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
			
}
