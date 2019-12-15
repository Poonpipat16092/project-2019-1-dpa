package object;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class supplyBullet extends SupplyObject {
	public static final int width=20;
	public static final int height=20;
	private int mode;
	
	public supplyBullet(ObjectHandler handler){
		super(random.nextInt(780)+20,random.nextInt(200)-400,ID.Supply,handler);
		mode=random.nextInt(2);
		velX=0;
		velY=2;
		limitX=800;
		limitY=700;
		handler.addObject(this);

	}

	@Override
	public void tick() {
		checkShow();
		if(isShow()==false) return;
		y+=velY;
		collision();
	}

	@Override
	public void draw(GraphicsContext gc) {
		if(!isShow) return;
		if(mode==0) {
			gc.setFill(Color.BLUE);
			gc.fillRect(x, y, width, height);
		}
		if(mode==1) {
			gc.setFill(Color.GREEN);
			gc.fillRect(x, y, width, height);
		}
	}
	
	public void collision() {
		for(GameObject temp:handler.getObjects()) {
			if(temp.id==ID.Player && temp.getZ()==0) {
				if(getBounds().intersects(temp.getBounds().getBoundsInLocal()) && temp.isShow){
					((Player) temp).setMode(mode);
					setShow(false);
				}
			}
		}
	}

	@Override
	public int getZ() {
		return 2;
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x,y,width,height);
	}

	@Override
	public void getHit(int damage) {
		setShow(false);
	}

	@Override
	public void checkShow() {
		if(x<-50 || x>limitX) {
			this.setShow(false);
			return;
		}
		if(y>limitY) {
			this.setShow(false);
			return;
		}
	}

}
