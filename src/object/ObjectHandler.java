package object;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import graphic.GameHud;
import graphic.GameScreen;
import javafx.scene.canvas.GraphicsContext;

public class ObjectHandler {
	
	private List<GameObject> objects;
	private Comparator<GameObject> comparator;
	
	public ObjectHandler() {
		objects=new ArrayList<GameObject>();
		comparator=(GameObject o1,GameObject o2)->{
			if(o1.getZ()>o2.getZ()) return 1;
			return -1;
		};
	}
	
	public void tick() {
		for(int i=0;i<objects.size();i++) {
			objects.get(i).tick(); 
		}
	}
	
	public void draw(GraphicsContext gc) {
		for(GameObject temp:objects) {
			temp.draw(gc);
		}
	}
	
	public void removeNotShow() {
		for(int i=0;i<objects.size();i++) {
			if(objects.get(i).isShow()==false) {
				GameScreen.getHud().addScore(objects.get(i).getScore());
				objects.remove(i);
			}
		}
	}

	public void addObject(GameObject object) {
		objects.add(object);
		objects.sort(comparator);
	}
	
	public void removeObject(GameObject object) {
		objects.remove(object);
	}

	public List<GameObject> getObjects() {
		return objects;
	}
	
}
