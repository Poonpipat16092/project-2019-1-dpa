package graphic;

import javafx.scene.media.AudioClip;
import javafx.scene.media.MediaPlayer;

public class AudioLoader {
	
	public static final AudioClip START_SCREEN_SOUND= new AudioClip(ClassLoader.getSystemResource("startScreenSound.mp3").toString());
	public static final AudioClip MEGA_LASER = new AudioClip(ClassLoader.getSystemResource("megaLaser.wav").toString());
	public static final AudioClip BUTTON_CLICK = new AudioClip(ClassLoader.getSystemResource("buttonclick.mp3").toString());
	public static final AudioClip COLLET_SUPPLY = new AudioClip(ClassLoader.getSystemResource("collectsupply.mp3").toString());
	public static final AudioClip DIED = new AudioClip(ClassLoader.getSystemResource("died.mp3").toString());
	public static final AudioClip ERRORR = new AudioClip(ClassLoader.getSystemResource("error.mp3").toString());
	public static final AudioClip BOSS_MUSIC = new AudioClip(ClassLoader.getSystemResource("BossMusic.mp3").toString());
}
