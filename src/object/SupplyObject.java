package object;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Shape;

public abstract class SupplyObject extends GameObject{

	public SupplyObject(double x,double y,ID id,ObjectHandler handler) {
		super(x,y,id,handler);
	}

}