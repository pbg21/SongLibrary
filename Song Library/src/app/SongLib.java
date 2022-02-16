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


/*
 * The Idea that I am going with is to abstract the properties and functions depending on weather they 
 * make sense to be connected to a controller (which is bounded by an instance of a stage) or if they
 * are independent to the instance of the stage.
 * 
 * So I have all the File IO operations in this SongLib File that can be called by controllers to get
 * the information of the file and also save it. Not all methods are implemented but I am trying to
 * form a basic skeleton of the code, then we can start populating the methods.
 * 
 * 
 */
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
				controller.start(primaryStage);

				// set scene to root and other stage preferences
				Scene scene = new Scene(root);
				primaryStage.setScene(scene);
				primaryStage.setTitle("Song Library");
				primaryStage.setResizable(false);
				primaryStage.show();
	}

	//Writes songList data into the file for storage. (NOT FINISHED)
	public static void writeList(ArrayList<Song> songlist) {
		
	}
	
	
	//loads all songs in file to ArrayList and returns it;
	public static ArrayList<Song> getSongList(){
				BufferedReader reader = null;
				ArrayList<Song> list = new ArrayList<>();
				try {
					reader = new BufferedReader(new FileReader("src/app/songs.txt"));
					String s;
					while((s = reader.readLine()) != null) {
						String[] sarr = s.split(",");
						list.add(new Song(sarr[0], sarr[1], sarr[2], sarr[3]));
					}
					reader.close();
					return list;
				}catch(FileNotFoundException e) {
					System.out.println(e.getStackTrace());
				}catch(IOException e) {
					System.out.println(e.getStackTrace());
				}catch(Exception e) {
					System.out.println(e.getStackTrace());
				}
				return null;
			}

	
	public static void main(String[] args) {
		launch(args);
	}
}
