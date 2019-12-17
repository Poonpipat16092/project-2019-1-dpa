package object;


import graphic.GameScreen;
import graphic.ImageLoader;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Enemy3 extends BattleshipObject {
	public int totalSpeed;
	
	public Enemy3(ObjectHandler handler){
		super(random.nextInt(800),random.nextInt(200)-300,ID.Enemy,handler,50,50);
		setDamage(1);
		setScore(50);
		setTotalSpeed(4);
		hp=2;
		limitX=800;
		limitY=700;
		handler.addObject(this);
	}

	@Override
	public void tick() {
		if(isShow()==false) return;
		setSpeed();
		x+=velX;
		y+=velY;
		collision();
		checkShow();
	}

	@Override
	public void draw(GraphicsContext gc) {
		if(isShow()==false) return;
		gc.drawImage(ImageLoader.ENEMY3, x, y);
//		gc.setFill(Color.PURPLE);
//		gc.fillRect(x, y, width , height);
	}
	
	public void collision() {
		for(GameObject temp:handler.getObjects()) {
			if(temp.getId()==ID.Player) {
				if(getBounds().intersects(temp.getBounds().getBoundsInLocal()) && temp.isShow){
					temp.getHit(this);
					getHit(temp);
				}
			}
		}
	}
		
	@Override
	public int getZ() {
		return 1;
	}

		
	public void setSpeed() {
		velX=totalSpeed*cos();
		velY=totalSpeed*sin();
	}

	public int getTotalSpeed() {
		return totalSpeed;
	}

	public void setTotalSpeed(int totalSpeed) {
		this.totalSpeed = totalSpeed;
	}

		

}
