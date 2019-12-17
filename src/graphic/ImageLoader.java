package graphic;

import javafx.scene.image.Image;
import javafx.scene.text.Font;


import graphic.Screen;


public class ImageLoader {
	
	public static final Image GAME_SCREEN=new Image("gameScreen.jpg",Screen.WIDTH,Screen.HEIGHT,false,true);
	public static final Image BOOM = new Image("Boom.png",200,200,true,true);
	public static final Image START_SCREEN = new Image("startScreen.jpg",Screen.WIDTH,Screen.HEIGHT,false,true);
	public static final Image PLAYER1 = new Image("player1.png",100,100,true,true);
	public static final Image PLAYER2 = new Image("player2.png",100,100,true,true);
	public static final Image INGAME_PLAYER1 = new Image("player1.png",70,70,true,true);
	public static final Image INGAME_PLAYER2 = new Image("player2.png",70,70,true,true);
	public static final Image BOSS_CHARGING=new Image("laserRedShot.png", 20, 20, false, true);
	public static final Image BOSS=new Image("Boss.png", 400, 100, false, true);
	public static final Image BOSS_NORMAL_BULLET=new Image("BossNormalBullet.png", 20, 20, false, true);
	public static final Image BOSS_LASERBEAM=new Image("MeagaLaser.jpg", 100, 700, false, true);
	public static final Image PLAYER_LASER2=new Image("laserBlue02.png",10,20,true,true);
	public static final Image PLAYER_LASER=new Image("laserGreen.png",10,20,true,true);
	public static final Image ENEMY_LASER=new Image("laserRed.png",10,20,true,true);
	public static final Image ENEMY1=new Image("meteorSmall.png",50,50,true,true);
	public static final Image ENEMY2=new Image("enemy2.png",60,90,false,true);
	public static final Image ENEMY3=new Image("ufoRed.png", 50, 50, false, true);
	public static final Image BARRIER=new Image("barrier.png",70,70,false,true);
	public static final Image BARRIER_ICON=new Image("barria.png", 30, 30, false, true);
	public static final Image GREEN_AMMUNITION_ICON=new Image("greenSupply.png", 30, 30, false, true);
	public static final Image BLUE_AMMUNITION_ICON=new Image("blueSupply.png", 30, 30, false, true);
	public static final Image HEALTH_ICON=new Image("healthIcon.png", 30, 30, false, true);
	public static final Image WINNER_CUP = new Image("winnercup.png",200,200,true,true);
}
