package graphic;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.*;

public class StartScreen implements Screen{
	
	//Suggest: private static final Font
	//TODO:add background image,background song,click song
	private Stage primarystage ;
	private Canvas canvas;
	private GraphicsContext gc;
	private VBox menu;
	
	
	public StartScreen(Stage Primarystage) {
		canvas=new Canvas(WIDTH, HEIGHT);
		gc=canvas.getGraphicsContext2D();
		setupMenu();
		
		primarystage = Primarystage ;
		primarystage.setTitle("DPA");
		primarystage.setResizable(false);
		primarystage.setWidth(WIDTH);
		primarystage.setHeight(HEIGHT);
	
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		Pane root=new Pane();
		root.setPrefSize(WIDTH, HEIGHT);
		gc.drawImage(START_SCREEN, 0, 0);
		root.getChildren().add(canvas);
		canvas.requestFocus();
		
		Scene scene = new Scene(root);
		primarystage.setScene(scene);
		
		//add black background
//		gc.setFill(Color.BLACK);
//		gc.fillRect(0, 0, WIDTH, HEIGHT);
				
		
		//add menu
		root.getChildren().add(menu);
	}
	
	@Override
	public void startAnimation() {
		draw(gc);
	}
	
	public void setupMenu() {
		this.menu=new VBox();
		menu.setPrefWidth(800);
		menu.setPrefHeight(200);
		menu.setSpacing(50);
		menu.setPadding(new Insets(30,40,10,10));//up,right
		menu.setAlignment(Pos.BOTTOM_RIGHT);
		
		Button start = new Button("Start");
		Button exit = new Button("Exit");
		start.setPrefSize(120, 90);
		exit.setPrefSize(120, 90);
		//TODO:add font and color
		start.setFont(mainFont);
		exit.setFont(mainFont);
		start.setStyle("-fx-background-color: #000000; -fx-text-fill: #ffffff;-fx-border-color: #4F42B5;-fx-border-width: 2px");
		exit.setStyle("-fx-background-color: #000000; -fx-text-fill: #ffffff;-fx-border-color: #4F42B5;-fx-border-width: 2px;");

		start.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				SelectPlayerScreen selectedPlayer = new SelectPlayerScreen(primarystage);
				selectedPlayer.startAnimation();
				
			}
		});
		
		exit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				Platform.exit();
			}
		});
		menu.getChildren().addAll(start,exit);
	}
}
