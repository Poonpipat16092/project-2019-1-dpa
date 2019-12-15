package object;


import graphic.GameScreen;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Enemy3 extends BattleshipObject {
	public static final int width=40;
	public static final int height=40;
	public static final double speed=4;
	public int hp;
	private Image image;
	
	public Enemy3(ObjectHandler handler){
		super(random.nextInt(800),random.nextInt(200)-300,ID.Enemy,handler);
		setDamage(1);
		setScore(50);
		hp=2;
		limitX=800;
		limitY=700;
		handler.addObject(this);
	}

	@Override
	public void tick() {
		if(isShow()==false) return;
		x+=speed*cos();
		y+=speed*sin();
		collosion();
	}

	@Override
	public void draw(GraphicsContext gc) {
		if(isShow()==false) return;
		gc.setFill(Color.PURPLE);
		gc.fillRect(x, y, width , height);
	}
	
	public void collosion() {
		for(GameObject temp:handler.getObjects()) {
			if(temp.getId()==ID.Player) {
				if(getBounds().intersects(temp.getBounds().getBoundsInLocal()) && temp.isShow){
					temp.getHit(getDamage());
					getHit(((Damagable) temp).getDamage());
				}
			}
		}
	}
		
	@Override
	public int getZ() {
		return 1;
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x,y,width,height);
	}

	@Override
	public void getHit(int damage) {
		hp-=damage;
		checkShow();
	}

	@Override
	public void checkShow() {
		if(hp<=0) setShow(false);
		if(y>limitY) {
			this.setShow(false);
			return;
		}
	}

}
