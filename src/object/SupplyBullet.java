package object;

import graphic.AudioLoader;
import graphic.ImageLoader;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class SupplyBullet extends SupplyObject {
	private int mode;
	
	
	public SupplyBullet(ObjectHandler handler){
		super(random.nextInt(770),random.nextInt(200)-400,ID.Supply,handler);
		mode=random.nextInt(2);
		handler.addObject(this);

	}

	@Override
	public void draw(GraphicsContext gc) {
		if(!isShow) return;
		if(mode==0) {
			gc.drawImage(ImageLoader.BLUE_AMMUNITION_ICON, x, y);
		}
		if(mode==1) {
			gc.drawImage(ImageLoader.GREEN_AMMUNITION_ICON, x, y);
		}
	}
	
	public void collision() {
		for(GameObject temp:handler.getObjects()) {
			if(temp.id==ID.Player && temp.getZ()==0) {
				if(getBounds().intersects(temp.getBounds().getBoundsInLocal()) && temp.isShow){
					AudioLoader.COLLECT_SUPPLY.play();
					((Player) temp).setMode(mode);
					getHit(this);;
				}
			}
		}
	}

	@Override
	public int getZ() {
		return 2;
	}


	@Override
	public void getHit(GameObject object) {
		setShow(false);
	}


}
