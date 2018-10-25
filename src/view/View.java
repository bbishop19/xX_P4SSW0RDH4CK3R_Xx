package view;

import java.util.Arrays;

import javafx.application.Application;
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
		Button wwh = new Button("Windward Hack");
		wwh.relocate(100, 300);
		Button ch = new Button();
		ch.relocate(200, 300);
		Button bf = new Button();
		bf.relocate(300,  300);
		TextField password = new TextField();
		root.getChildren().addAll(Arrays.asList(password, wwh, ch, bf));
		
		stage.setScene(new Scene(root, 500, 500));
		stage.show();
	}
}
