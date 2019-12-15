package graphic;

import javafx.animation.AnimationTimer;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
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
import object.supplyBarrier;
import object.supplyBullet;
import object.supplyHealth;

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
	
	private static Player player;
	private boolean[] keyDown;
	private boolean pause = false ;
	
	public GameScreen(Stage Primarystage) {
		primarystage=Primarystage;
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
				gc.setFill(Color.BLACK);
				gc.fillRect(0, 0, WIDTH, HEIGHT);
				//handler with object
				handler.draw(gc);
				handler.tick();
				hud.draw(gc);
				updateHud();
				isGameOver();
				nextStage();
				gc.setFill(Color.ANTIQUEWHITE);
				gc.setFont(new Font(20));
				gc.fillText("stageTimer : "+stageTime, 500, 580);
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
				supplyHealth supply = new supplyHealth(handler);
			}
			if(stageTime%500==300) {
				supplyBarrier supply = new supplyBarrier(handler);
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
				supplyHealth supply = new supplyHealth(handler);
			}
			if(stageTime%500==300) {
				supplyBarrier supply = new supplyBarrier(handler);
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
				supplyHealth supply = new supplyHealth(handler);
			}
			if(stageTime%500==200) {
				supplyBarrier supply = new supplyBarrier(handler);
			}
			if(stageTime%700==300) {
				supplyBullet supply = new supplyBullet(handler);
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
				supplyHealth supply = new supplyHealth(handler);
			}
			if(stageTime%500==200) {
				supplyBarrier supply = new supplyBarrier(handler);
			}
			if(stageTime%700==200){
				supplyBullet supply = new supplyBullet(handler);
			}
		}
		
		if(stage==5) {
			
			if(stageTime==100) {
				Boss boss=new Boss(handler);
			}
			if(stageTime%700==10) {
				supplyBullet supply=new supplyBullet(handler);
			}
			if(stageTime%400==200) {
				supplyHealth supply=new supplyHealth(handler);
			}
			if(stageTime%300==100) {
				supplyBarrier supply=new supplyBarrier(handler);
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
			stageTime=0;
			stage+=1;
		}
		if(stage==2 && stageTime>=4000) {
			stageTime=0;
			stage+=1;
		}
		if(stage==3 && stageTime>=4000) {
			stageTime=0;
			stage+=1;
		}
		if(stage==4 && stageTime>=4000) {
			stageTime=0;
			stage+=1;
		}
		if(stage==5) {
			//ending scene//
		}
	}
		
	@Override
	public void startAnimation() {
		draw(gc);
	}
	
	public void isGameOver() {
		if(!player.isShow()) {
			timer.stop();
			GameOverScreen end = new GameOverScreen(primarystage);
			end.startAnimation();
		}
	}

	public static Player getPlayer() {
		return player;
	}

	public static GameHud getHud() {
		return hud;
	}
	
	
	
}