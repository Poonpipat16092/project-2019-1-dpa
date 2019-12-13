package object;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Player extends GameObject {
	public static final int width=60;
	public static final int height=60;
	private int hp;
	private int selfTimer=0;
	public static final Image image=new Image("player1.png",width,height,true,true);

	public Player(ObjectHandler handler) {
		super(400,500,ID.Player,handler);
		setDamage(1);
		hp=5;
		velX=0;
		velY=0;
		limitX=800;
		limitY=600;
		handler.addObject(this);
	}
	
	@Override
	public void tick() {
		if(!isShow) return;
		x+=velX;
		y+=velY;
		if(selfTimer>=30) {
			Bullet bullet=new Bullet(x+width/2, y, id, 1, handler);
			selfTimer=0;
		}
		// find the limit of scene(edit this when got fix size)
		if(x<=0) x=0;
		if(x>=limitX-width) x=limitX-width;
		if(y<=0) y=0;
		if(y>=limitY-height*4/3) y=limitY-height*4/3;

		collision();
		selfTimer++;
	}
	
	public void collision() {
		//when being hit //can minimize round with getZ to only check some Z
		for(GameObject temp:handler.getObjects()) {
			if(temp.getId()==ID.Enemy) {
				if(getBounds().intersects(temp.getBounds().getBoundsInLocal()) && temp.isShow){
					getHit(temp.getDamage());
					temp.getHit(getDamage());
				}
			}
		}
		
	}
	
	public void getHit(int damage) {
		hp-=damage;
		checkShow();
	}
	
	public void getHealth(int health) {
		hp+=health;
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		if(!isShow) return;
		gc.setFill(Color.WHITE);
		gc.fillRect(x, y, width, height);
		gc.drawImage(image, x, y);
		//check hp
	}
		
	public void checkShow() {
		if(hp<=0) setShow(false);
	}

	public int getZ() {
		return 0;
	}
	
	public int getHp() {
		return hp;
	}
	
	public Shape getBounds() {
		//size of the hit box
		return new Rectangle(x,y,width, height);
	}
	
}
