package view;

import java.util.Arrays;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class View extends Application{	
	public static void main(String[] args){
		launch(args);
	}
	
	public void start(Stage stage) throws Exception {
		TilePane mainMenuRoot = new TilePane();

		PasswordField password = new PasswordField();
		password.setPromptText("Enter password here");
		password.setPrefSize(300, 30);
		password.setAlignment(Pos.CENTER);


		Button wwh = new Button("Windward Hack");
		wwh.setPrefSize(300, 30);
		wwh.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                //todo
            }
        });

		Button ch = new Button("Common Passwords");
        ch.setPrefSize(300, 30);
        ch.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                //todo
            }
        });

		Button bf = new Button("Brute Force");
        bf.setPrefSize(300, 30);
        bf.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                //todo
            }
        });

		mainMenuRoot.getChildren().addAll(password, wwh, ch, bf);
		Scene mainMenu = new Scene(mainMenuRoot, 300, 120);

		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

		TilePane infoRoot = new TilePane();
		infoRoot.setPrefSize(300, 120);
		infoRoot.setAlignment(Pos.CENTER);


		Text crackedMessage = new Text("Your password was cracked in");

		Text timeMessage = new Text("1234 ms and");

		Text attemptsMessage = new Text("5678 attempts");

		Button backButton = new Button("Test again");
		backButton.setPrefSize(300, 30);
		backButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				stage.setScene(mainMenu);
			}
		});


		infoRoot.getChildren().addAll(crackedMessage, timeMessage, attemptsMessage, backButton);

		Scene infoScreen = new Scene(infoRoot, 300, 120);

		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

		stage.setScene(infoScreen);
		stage.setResizable(false);
		stage.show();
	}
}
