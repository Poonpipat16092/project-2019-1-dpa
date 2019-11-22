package Object;

import java.util.LinkedList;

import javafx.scene.canvas.GraphicsContext;

public class ObjectHandler {
	
	LinkedList<GameObject> objects =new LinkedList<GameObject>();
	
	public void tick() {
		for(GameObject temp:objects) {
			temp.tick(); 
		}
	}
	
	public void draw(GraphicsContext gc) {
		for(GameObject temp:objects) {
			temp.draw(gc);
		}
	}

	public void addObject(GameObject object) {
		objects.add(object);
	}
	
	public void removeObject(GameObject object) {
		objects.remove(object);
	}
}
