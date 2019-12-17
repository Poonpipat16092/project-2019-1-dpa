package object;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.media.AudioClip;
import javafx.scene.shape.Shape;

public abstract class SupplyObject extends GameObject{
	public abstract void collision();
	
	@Override
	public void tick() {
		checkShow();
		if(isShow()==false) return;
		y+=velY;
		collision();
	}


	public SupplyObject(double x,double y,ID id,ObjectHandler handler) {
		super(x,y,id,handler,30,30);
		velX=0;
		velY=2;
		limitX=800;
		limitY=700;
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
