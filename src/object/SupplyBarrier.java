package object;

import graphic.AudioLoader;
import graphic.ImageLoader;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class SupplyBarrier extends SupplyObject {
		
	public SupplyBarrier(ObjectHandler handler){
		super(random.nextInt(770),random.nextInt(200)-400,ID.Supply,handler);
		handler.addObject(this);
		//
	}


	@Override
	public void draw(GraphicsContext gc) {
		if(!isShow) return;
		gc.drawImage(ImageLoader.BARRIER_ICON, x, y);
	}
	
	public void collision() {
		for(GameObject temp:handler.getObjects()) {
			if(temp.id==ID.Player && temp.getZ()==0) {
				if(getBounds().intersects(temp.getBounds().getBoundsInLocal()) && temp.isShow){
					AudioLoader.COLLECT_SUPPLY.play();
					((Player) temp).setBarrier(true);
					getHit(temp);;
				}
			}
		}
	}

	@Override
	public int getZ() {
		return 2;
	}

	@Override
	public void getHit(GameObject gameObject) {
		setShow(false);
	}

	
}
