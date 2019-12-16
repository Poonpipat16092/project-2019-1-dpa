package object;

import java.util.Random;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Enemy2 extends BattleshipObject {
	public static final Image image=new Image("enemy2.png",60,90,false,true);
	private int hp;
	private int selfTimer=0;
	public Enemy2(ObjectHandler handler) {
		super(random.nextInt(800-60),random.nextInt(200)-400,ID.Enemy,handler,60,90);
		setDamage(1);
		setScore(50);
		hp=2;
		velX=2;
		velY=2;
		limitX=800;
		limitY=100;
		handler.addObject(this);
	}
	
	@Override
	public void tick() {
		checkShow();
		if(!isShow) return;
		x+=velX;
		y+=velY;
		if(x<0) x=0;
		if(x>limitX) x=limitX;
		if(x>=limitX-width || x<=0) velX*=-1; 
		if(y>limitY) y=limitY;
		shooting();
		collision();
		selfTimer++;
	}

	public void collision() {
		//when being hit //can minimize round with getZ to only check some Z
		for(GameObject temp:handler.getObjects()) {
			if(temp.getId()==ID.Player) {
				if(getBounds().intersects(temp.getBounds().getBoundsInLocal()) && temp.isShow){
					temp.getHit(this);
					getHit(temp);
				}
			}
		}
	}
	
	public void shooting() {
		if(!isShow) return;
		if(selfTimer%75==10) new Bullet(x+width/2, y+height,0,7, getId(), getDamage(), handler);
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		if(!isShow) return;
//		gc.setFill(Color.BLUE);
//		gc.fillRect(x, y, width, height);
		gc.drawImage(image, x, y);
	}

	@Override
	public int getZ() {
		return 0;
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x,y,width,height);
	}

	@Override
	public void getHit(GameObject object) {
		if(object instanceof Damagable) hp-=((Damagable) object).getDamage();
		checkShow();
	}

	@Override
	public void checkShow() {
		if(hp<=0) setShow(false);
	}

}
