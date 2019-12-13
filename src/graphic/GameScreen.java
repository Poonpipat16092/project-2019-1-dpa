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
import javafx.stage.Stage;
import object.Enemy1;
import object.Enemy2;
import object.GameObject;
import object.ID;
import object.ObjectHandler;
import object.Player;

public class GameScreen implements Screen {
	private Stage primarystage;
	private Canvas canvas;
	private GraphicsContext gc;
	private Pane root;
	private AnimationTimer timer;
	private ObjectHandler handler=new ObjectHandler();
	private int stage=1;
	private int stageTime=0;
	
	private Player player;
	private boolean[] keyDown;
	
	public GameScreen(Stage Primarystage) {
		primarystage=Primarystage;
		canvas=new Canvas(WIDTH,HEIGHT);
		gc=canvas.getGraphicsContext2D();
		
		
		//test handler
		player =new Player(100,100,handler);
		handler.addObject(player);
	
		
		root=new Pane();
		root.setPrefSize(WIDTH, HEIGHT);
		root.getChildren().add(canvas);
		canvas.requestFocus();
		
		//setSound
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, WIDTH, HEIGHT);

		timer=new AnimationTimer() {
			@Override
			public void handle(long current) {
				spawnEnemy();
				//reset background
				gc.setFill(Color.BLACK);
				gc.fillRect(0, 0, WIDTH, HEIGHT);
				//handler with object
				handler.draw(gc);
				handler.tick();
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
	
	public void spawnEnemy() {
		if(stage==1) {
			if(stageTime%100==0) {
				Enemy1 enemy = new Enemy1(100, 0, handler);
			}
			if(stageTime%200==0) {
				Enemy2 enemy = new Enemy2(400,0,handler);
			}
		}
		stageTime++;
	}
	
	@Override
	public void startAnimation() {
		draw(gc);
	}

}
