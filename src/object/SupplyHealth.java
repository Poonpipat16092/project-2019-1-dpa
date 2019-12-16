package object;

import graphic.AudioLoader;
import graphic.ImageLoader;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class SupplyHealth extends SupplyObject {

	
	public SupplyHealth(ObjectHandler handler){
		super(random.nextInt(770),random.nextInt(200)-400,ID.Supply,handler);
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
		gc.drawImage(ImageLoader.HEALTH_ICON, x, y);
	}
	
	public void collision() {
		for(GameObject temp:handler.getObjects()) {
			if(temp.id==ID.Player && temp.getZ()==0) {
				if(getBounds().intersects(temp.getBounds().getBoundsInLocal()) && temp.isShow){
					AudioLoader.COLLECT_SUPPLY.play();
					((Player) temp).getHealth(1);
					getHit(temp);
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
	public void getHit(GameObject object) {
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
