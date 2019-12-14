package graphic;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SelectPlayerScreen implements Screen {
	
	public static final Image Player1 = new Image("player1.png",100,100,true,true);
	public static final Image Player2 = new Image("player2.png",100,100,true,true);
	public static final Font SELECT_PLAYER = new Font("supermarket.ttf", 75);
	public static final Font START = new Font("supermarket.ttf", 20);
	private Button player1,player2,startButton;
	private Stage primarystage ;
	private GraphicsContext gc ;
	private Canvas canvas ;
	private HBox player,start;
	private String selectedPlayer ;
	private ObservableList<Button> playerButtonList = FXCollections.observableArrayList();
	
	
	public SelectPlayerScreen(Stage primarystage) {
		// TODO Auto-generated constructor stub
		canvas = new Canvas(WIDTH,HEIGHT);
		gc = canvas.getGraphicsContext2D();
		selectedPlayer = "" ;
		setupbutton();
		
		this.primarystage = primarystage ;
		
		
	}
	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		Pane root = new Pane();
		root.setPrefSize(WIDTH, HEIGHT);
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, WIDTH, HEIGHT);
		
		gc.setFont(SELECT_PLAYER);
		gc.setFill(Color.WHITE);
		gc.setLineWidth(2);
		gc.fillText("Select Player", 150, 100);
		
		root.getChildren().add(canvas);
		
		Scene scene = new Scene(root);
		primarystage.setScene(scene);
		root.getChildren().addAll(player,start);
		
		
		
	}

	@Override
	public void startAnimation() {
		// TODO Auto-generated method stub
		draw(gc);

	}
	public void setupbutton() {
		this.player = new HBox();
		player.setPrefWidth(800);
		player.setPrefHeight(400);
		player.setSpacing(50);
		player.setPadding(new Insets(10,10,10,10));//up,right
		player.setAlignment(Pos.CENTER);
		
		
		player1 = new Button("Player1");
		player1.setGraphic(new ImageView(Player1));
		player1.setPrefSize(100,100);
		
		player2 = new Button("Player2");
		player2.setGraphic(new ImageView(Player2));
		player2.setPrefSize(100, 100);
		
		player1.setStyle("-fx-background-color: #000000;");
		player2.setStyle("-fx-background-color: #000000;");
		
		player1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				if(selectedPlayer != "Player1" ) {
					player1.setStyle("-fx-background-color: #7FFFD4; ");
					selectedPlayer = "Player1";
					player2.setStyle("-fx-background-color: #000000; ");
				}
			}
		});
		player2.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				if(selectedPlayer != "Player1" ) {
					player2.setStyle("-fx-background-color: #7FFFD4; ");
					selectedPlayer = "Player1";
					player1.setStyle("-fx-background-color: #000000; ");
				}
			}
		});
		
		this.start = new HBox();
		start.setPrefWidth(800);
		start.setPrefHeight(100);
		start.setSpacing(50);
		start.setPadding(new Insets(400,10,10,10));//up,right
		start.setAlignment(Pos.BOTTOM_CENTER);
		
		startButton = new Button("start");
		startButton.setPrefSize(100, 100);
		startButton.setFont(START);
		
		startButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(selectedPlayer == "") {
					Alert alert = new Alert(AlertType.INFORMATION,"Please Select Player");
					alert.showAndWait();
					return;
				}
				else {
					GameScreen game=new GameScreen(primarystage);
					game.startAnimation();
					System.out.println(selectedPlayer);
				}
			}
		});
		
		
		player.getChildren().addAll(player1,player2);
		start.getChildren().addAll(startButton);
		
	}

}
