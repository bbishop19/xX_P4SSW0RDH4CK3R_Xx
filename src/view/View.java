package view;

import java.util.Arrays;

import controller.Controller;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class View extends Application{	
	public static void main(String[] args){
		launch(args);
	}
	
	public void start(Stage stage) throws Exception {
		Group root = new Group();

		PasswordField password = new PasswordField();
		password.setPromptText("Enter password here");
		password.setPrefSize(200, 30);
		password.setAlignment(Pos.CENTER);

		Button wwh = new Button("Windward Hack");
		wwh.setPrefSize(200, 30);
		wwh.relocate(0, 30);
		wwh.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                //todo
            }
        });

		Button ch = new Button("Common Passwords");
        ch.setPrefSize(200, 30);
		ch.relocate(0, 60);
        ch.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                //todo
            }
        });

		Button bf = new Button("Brute Force");
        bf.setPrefSize(200, 30);
		bf.relocate(0,  90);
        bf.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                //todo
            }
        });

		root.getChildren().addAll(Arrays.asList(password, wwh, ch, bf));
		
		stage.setScene(new Scene(root, 200, 120));
		stage.show();
	}
}
