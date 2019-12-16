package graphic;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

public class AudioLoader {
	
	public static final AudioClip START_SCREEN_SOUND = new AudioClip(ClassLoader.getSystemResource("startScreenSound.mp3").toString());
	public static final AudioClip MEGA_LASER = new AudioClip(ClassLoader.getSystemResource("megaLaser.wav").toString());
	public static final AudioClip BUTTON_CLICK = new AudioClip(ClassLoader.getSystemResource("buttonclick.mp3").toString());
	public static final AudioClip COLLECT_SUPPLY = new AudioClip(ClassLoader.getSystemResource("collectsupply.mp3").toString());
	public static final AudioClip DIED = new AudioClip(ClassLoader.getSystemResource("died.mp3").toString());
	public static final AudioClip ERRORR = new AudioClip(ClassLoader.getSystemResource("error.mp3").toString());
	public static final Image BOSSCHARGING=new Image("laserRedShot.png", 20, 20, false, true);
	public static final Image BOSS=new Image("Boss.png", 400, 100, false, true);
	
}
