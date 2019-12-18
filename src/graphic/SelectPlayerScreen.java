package graphic;

import exception.BarrierOnException;
import exception.NullSelectPlayerException;
import javafx.event.ActionEvent;
import javafx.event.Event;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SelectPlayerScreen implements Screen {
	
	private Button player1,player2,playtButton;
	private Stage primarystage ;
	private GraphicsContext gc ;
	private Canvas canvas ;
	private HBox player,start;
	private String selectedPlayer ;
	
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
		
		gc.setFont(HEADER_FONT);
		gc.setFill(Color.YELLOW);
		gc.setLineWidth(2);
		gc.fillText("Select Player", 205, 100);
		
		gc.setFill(Color.WHITE);
		gc.setFont(SELECT_PLAYER);
		gc.fillText("Player 1", 170, 350);
		gc.fillText("Player 2", 475, 350);
		
		root.getChildren().add(canvas);
		
		Scene scene = new Scene(root);
		primarystage.setScene(scene);
		root.getChildren().addAll(start,player);
		
		
		
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
		player.setSpacing(100);
		player.setPadding(new Insets(50,10,10,10));
		player.setAlignment(Pos.CENTER);
		
		
		player1 = new Button();
		player1.setGraphic(new ImageView(ImageLoader.PLAYER1));
		player1.setPrefSize(200,150);
		
		player2 = new Button();
		player2.setGraphic(new ImageView(ImageLoader.PLAYER2));
		player2.setPrefSize(200, 150);
		
		player1.setStyle("-fx-background-color: #000000;");
		player2.setStyle("-fx-background-color: #000000;");
		
		player1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				if(selectedPlayer != "Player1" ) {
					AudioLoader.BUTTON_CLICK.play();
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
				if(selectedPlayer != "Player2" ) {
					AudioLoader.BUTTON_CLICK.play();
					player2.setStyle("-fx-background-color: #7FFFD4; ");
					selectedPlayer = "Player2";
					player1.setStyle("-fx-background-color: #000000; ");
				}
			}
		});
		
		this.start = new HBox();
		start.setPrefWidth(800);
		start.setPrefHeight(100);
		start.setSpacing(50);
		start.setPadding(new Insets(425,15,10,10)); //down 400 
		start.setAlignment(Pos.BOTTOM_CENTER);
		
		playtButton = new Button("PLAY!");
		playtButton.setPrefSize(150, 150);
		playtButton.setStyle("-fx-background-color: #000000; -fx-text-fill: #ffffff;-fx-border-color: #4F42B5;-fx-border-width: 2px");
		playtButton.setFont(SELECT_PLAYER);
		
		playtButton.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				try {
					if(selectedPlayer == "") {
						AudioLoader.BUTTON_CLICK.play();
						Alert alert = new Alert(AlertType.INFORMATION,"Please Select Player");
						alert.showAndWait();
						throw new NullSelectPlayerException();
					}
					else {
						AudioLoader.BUTTON_CLICK.play();
						GameScreen game=new GameScreen(primarystage);
						game.getPlayer().setPlayer(selectedPlayer);
						game.startAnimation();
						System.out.println(selectedPlayer);
						AudioLoader.START_SONG.stopSong();
					}
					}
					catch (NullSelectPlayerException e) {
						System.out.println(e.getMessage());
					}
			}
		});
		
		
		player.getChildren().addAll(player1,player2);
		start.getChildren().addAll(playtButton);
		
	}
	/**
	 * @return the selectedPlayer
	 */
	public String getSelectedPlayer() {
		return selectedPlayer;
	}

}
