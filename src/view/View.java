package view;

import controller.Controller;
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
		//set up the main menu screen
		TilePane mainMenuRoot = new TilePane();

		PasswordField password = new PasswordField();
		password.setPromptText("Enter password here");
		password.setPrefSize(300, 30);
		password.setAlignment(Pos.CENTER);

		Button wwh = new Button("Windward Hack: O(1)");
		wwh.setPrefSize(300, 30);


		Button ch = new Button("Common Passwords: O(1)");
        ch.setPrefSize(300, 30);

		Button bf = new Button("Brute Force: O(2^n)");
        bf.setPrefSize(300, 30);

		mainMenuRoot.getChildren().addAll(password, wwh, ch, bf);
		Scene mainMenu = new Scene(mainMenuRoot, 300, 120);

		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

		//set up the info screen
		TilePane infoRoot = new TilePane();
		infoRoot.setPrefSize(300, 120);
		infoRoot.setAlignment(Pos.CENTER);


		Text crackedMessage = new Text("Your password was cracked in");

		Text timeMessage = new Text("1234 ms and");

		Text attemptsMessage = new Text("5678 attempts");

		Button backButton = new Button("Try again");
		backButton.setPrefSize(300, 30);



		infoRoot.getChildren().addAll(crackedMessage, timeMessage, attemptsMessage, backButton);

		Scene infoScreen = new Scene(infoRoot, 300, 120);



		stage.setScene(mainMenu);
		stage.setResizable(false);
		stage.show();

		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

		//set up button press handlers
		backButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				stage.setScene(mainMenu);
			}
		});

		wwh.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				Controller.windwardCrackAndDisplay(password.getText(), crackedMessage, timeMessage, attemptsMessage);
				stage.setScene(infoScreen);
			}
		});

		ch.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				Controller.commonCrackAndDisplay(password.getText(), crackedMessage, timeMessage, attemptsMessage);
				stage.setScene(infoScreen);
			}
		});

		bf.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				Controller.bruteForceCrackAndDisplay(password.getText(), crackedMessage, timeMessage, attemptsMessage);
				stage.setScene(infoScreen);
			}
		});
	}
}
