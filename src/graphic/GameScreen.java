package graphic;

import javafx.animation.AnimationTimer;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import object.Boss;
import object.Enemy1;
import object.Enemy2;
import object.Enemy3;
import object.GameObject;
import object.ID;
import object.ObjectHandler;
import object.Player;
import object.SupplyBarrier;
import object.SupplyBullet;
import object.SupplyHealth;

public class GameScreen implements Screen {
	private Stage primarystage;
	private Canvas canvas;
	private GraphicsContext gc;
	private Pane root;
	private AnimationTimer timer;
	private static GameHud hud;
	private ObjectHandler handler=new ObjectHandler();
	private int stage=1;
	private int stageTime=0;
	private boolean bossSpawn=false;
	private Boss boss;
	private static Player player;
	private boolean[] keyDown;
	private boolean pause = false ;
	
	public GameScreen(Stage primarystage) {
		this.primarystage= primarystage;
		canvas=new Canvas(WIDTH,HEIGHT);
		gc=canvas.getGraphicsContext2D();
		
		
		player =new Player(handler);
		hud=new GameHud(player);
	
		
		root=new Pane();
		root.setPrefSize(WIDTH, HEIGHT);
		root.getChildren().add(canvas);
		canvas.requestFocus();
		
		//setSound
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		
		timer=new AnimationTimer() {
			@Override
			public void handle(long current) {
				spawn();
				//reset background
				gc.drawImage(ImageLoader.GAME_SCREEN, 0, 0);
				//handler with object
				handler.draw(gc);
				handler.tick();
				hud.draw(gc);
				updateHud();
				isGameOver();
				nextStage();
			}
		};

		Scene scene=new Scene(root);
		primarystage.setScene(scene);
		setKeyEvent(scene);
				
		timer.start();

	}
	
	public void setKeyEvent(Scene scene) {
		keyDown= new boolean[4];
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			
			@Override
			public void handle(KeyEvent key) {
				if(key.getCode()==KeyCode.W) {
					player.setVelY(-5);
					keyDown[0]=true;
				}
				if(key.getCode()==KeyCode.A) {
					player.setVelX(-5);
					keyDown[3]=true;
				}
				if(key.getCode()==KeyCode.S) {
					player.setVelY(5);
					keyDown[1]=true;
				}
				if(key.getCode()==KeyCode.D) {
					player.setVelX(5);
					keyDown[2]=true;
				}
				if(key.getCode()==KeyCode.B) {
					stage=5;
					stageTime=0;
				}				
				if(key.getCode()==KeyCode.ESCAPE && pause == false) {
					pause = true ;
					timer.stop();
					PauseScreen.draw(gc);
				}
				if(key.getCode()==KeyCode.SPACE && pause) {
					timer.start();
					pause = false ;
				}
			}
			
		});
		
		scene.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent key) {
				if(key.getCode()==KeyCode.W) keyDown[0]=false;
				if(key.getCode()==KeyCode.A) keyDown[3]=false;
				if(key.getCode()==KeyCode.S) keyDown[1]=false;
				if(key.getCode()==KeyCode.D) keyDown[2]=false;
				
				if(!keyDown[0] && !keyDown[1]) player.setVelY(0);
				if(!keyDown[2] && !keyDown[3]) player.setVelX(0);
			}
			
		});

	}
	
	public void spawn() {
		if(stage==1) {
			
			if(stageTime%50==0) {
				Enemy1 enemy = new Enemy1(handler);
			}
			if(stageTime%100==50) {
				Enemy3 enemy = new Enemy3(handler);
			}
			if(stageTime%500==300) {
				SupplyHealth supply = new SupplyHealth(handler);
			}
			if(stageTime%500==300) {
				SupplyBarrier supply = new SupplyBarrier(handler);
			}
			if(stageTime%700==300) {
				SupplyBullet supply = new SupplyBullet(handler);
			}


		}
		if(stage==2) {
			
			if(stageTime%30==0) {
				Enemy1 enemy = new Enemy1(handler);
			}
			if(stageTime%75==50) {
				Enemy3 enemy = new Enemy3(handler);
			}
			if(stageTime%500==200) {
				SupplyHealth supply = new SupplyHealth(handler);
			}
			if(stageTime%500==300) {
				SupplyBarrier supply = new SupplyBarrier(handler);
			}
			if(stageTime%700==300) {
				SupplyBullet supply = new SupplyBullet(handler);
			}

			
		}
		if(stage==3) {
			
			if(stageTime%50==0) {
				Enemy1 enemy = new Enemy1(handler);
			}
			if(stageTime%125==50) {
				Enemy3 enemy = new Enemy3(handler);
			}
			if(stageTime%125==75) {
				Enemy2 enemy = new Enemy2(handler);
			}
			if(stageTime%500==100) {
				SupplyHealth supply = new SupplyHealth(handler);
			}
			if(stageTime%500==200) {
				SupplyBarrier supply = new SupplyBarrier(handler);
			}
			if(stageTime%700==300) {
				SupplyBullet supply = new SupplyBullet(handler);
			}
			
		}
		if(stage==4) {
			if(stageTime%50==0) {
				Enemy1 enemy = new Enemy1(handler);
			}
			if(stageTime%100==50) {
				Enemy2 enemy = new Enemy2(handler);
			}
			if(stageTime%100==75) {
				Enemy3 enemy = new Enemy3(handler);
			}
			if(stageTime%500==100) {
				SupplyHealth supply = new SupplyHealth(handler);
			}
			if(stageTime%500==200) {
				SupplyBarrier supply = new SupplyBarrier(handler);
			}
			if(stageTime%700==200){
				SupplyBullet supply = new SupplyBullet(handler);
			}
		}
		
		if(stage==5) {
			
			if(stageTime%50==0) {
				Enemy1 enemy = new Enemy1(handler);
			}
			if(stageTime==100) {
				AudioLoader.NORMAL_SONG.stopSong();
				AudioLoader.BOSS_SONG.playSong();
				boss=new Boss(handler);
				bossSpawn=true;
			}
			if(stageTime%700==10) {
				SupplyBullet supply=new SupplyBullet(handler);
			}
			if(stageTime%400==200) {
				SupplyHealth supply=new SupplyHealth(handler);
			}
			if(stageTime%300==100) {
				SupplyBarrier supply=new SupplyBarrier(handler);
			}

		}
		stageTime++;
	}
	
	public void updateHud() {
		handler.removeNotShow();
		hud.setStage(stage);
	}
	
	public void nextStage() {
		if(stage==1 && stageTime>=4000) {
			AudioLoader.NEXT_STAGE.play();
			stageTime=0;
			stage+=1;
		}
		if(stage==2 && stageTime>=4000) {
			AudioLoader.NEXT_STAGE.play();
			stageTime=0;
			stage+=1;
		}
		if(stage==3 && stageTime>=4000) {
			AudioLoader.NEXT_STAGE.play();
			stageTime=0;
			stage+=1;
		}
		if(stage==4 && stageTime>=4000) {
			AudioLoader.NEXT_STAGE.play();
			stageTime=0;
			stage+=1;
		}
	}
		
	@Override
	public void startAnimation() {
		AudioLoader.NORMAL_SONG.playSong();
		draw(gc);
	}
	
	public void isGameOver() {
		if(!player.isShow()) {
			boolean isWin = false;
			AudioLoader.DIED.play();
			AudioLoader.BOSS_SONG.stopSong();
			AudioLoader.NORMAL_SONG.stopSong();
			timer.stop();
			EndScreen end = new EndScreen(primarystage, isWin);
			end.startAnimation();
		}
		if(stage==5 && haveBossspawn() && !boss.isShow()) {
			AudioLoader.NORMAL_SONG.stopSong();
			AudioLoader.BOSS_SONG.stopSong();;
			boolean isWin = true ;
			AudioLoader.CONGRAT.play();
			bossSpawn=false;
			EndScreen end = new EndScreen(primarystage, isWin);
			end.startAnimation();
			//for Winner scene
		}
	}
	
	public boolean haveBossspawn() {
		return bossSpawn;
	}

	public static Player getPlayer() {
		return player;
	}

	public static GameHud getHud() {
		return hud;
	}
	
	
	
}