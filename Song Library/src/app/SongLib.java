package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.Stage;

public class SongLib extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		// create FXML loader
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("/views/root.fxml"));
				
				// load fmxl, root layout manager in fxml file is GridPane
				GridPane root = (GridPane)loader.load();

				// set scene to root
				Scene scene = new Scene(root);
				primaryStage.setScene(scene);
				primaryStage.setResizable(false);
				primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}


}
