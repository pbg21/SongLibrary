package app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import views.SLController;
import javafx.stage.Stage;

public class SongLib extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		// create FXML loader
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("/views/Main.fxml"));
				
				// load fmxl, root layout manager in fxml file is AnchorPane
				AnchorPane root = (AnchorPane)loader.load();
				
				//Loads Controller and starts it off 
				SLController controller = loader.getController();
				controller.start();

				// set scene to root
				Scene scene = new Scene(root);
				primaryStage.setScene(scene);
				primaryStage.setResizable(false);
				primaryStage.show();
	}
	
	//loads all songs in file to ArrayList and returns it;
		public ArrayList<Song> getSongList(){
				BufferedReader reader = null;
				ArrayList<Song> list = new ArrayList<>();
				try {
					reader = new BufferedReader(new FileReader("songs.txt"));
					String s;
					while((s = reader.readLine()) != null) {
						String[] sarr = s.split(",");
						list.add(new Song(sarr[0], sarr[1], sarr[2], sarr[3]));
					}
					reader.close();
					return list;
				}catch(FileNotFoundException e) {
					System.out.println("Fix it dumbass");
				}catch(IOException e) {
					System.out.println(e.getStackTrace());
				}
				return null;
			}
		
		
		//We would like to have a list of songs that is ordered in alphabetical ordered and can be motified given inserts and deletes
		//What class should have this list and where should it be used?
		
	public static void main(String[] args) {
		launch(args);
	}
}
