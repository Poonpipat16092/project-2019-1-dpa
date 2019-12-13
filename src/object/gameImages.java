package object;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;

public class gameImages {
	protected List<Image> images=new ArrayList<Image>();
	
	public gameImages() {
		String image_path=ClassLoader.getSystemResource("res/player1.png").toString();
		images.add(new Image(image_path));
		Image x=new Image("file:res/player1.png");
		images.add(x);
	}
	
	public Image getImage(int n) {
		return images.get(n);
	}
}
