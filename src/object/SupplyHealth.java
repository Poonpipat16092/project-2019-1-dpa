package object;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class SupplyHealth extends SupplyObject {
	public static final Image healthIcon=new Image("healthIcon.png", width, height, false, true);

	
	public SupplyHealth(ObjectHandler handler){
		super(random.nextInt(800),random.nextInt(200)-400,ID.Supply,handler);
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
		gc.drawImage(healthIcon, x, y);
	}
	
	public void collision() {
		for(GameObject temp:handler.getObjects()) {
			if(temp.id==ID.Player && temp.getZ()==0) {
				if(getBounds().intersects(temp.getBounds().getBoundsInLocal()) && temp.isShow){
					collectSupply.play();
					((Player) temp).getHealth(1);
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
