package views;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import app.Song;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class SLController {
	@FXML ListView<String> listView;
	ObservableList<String> obvList;
	@FXML Button delete;
	@FXML Button add;
	@FXML Text name;
	@FXML Text artist;
	@FXML Text album;
	@FXML Text year;
	
	@FXML TextField name_f;
	@FXML TextField artist_f;
	@FXML TextField album_f;
	@FXML TextField year_f;

	//Load all the written songs to the observable list.
	public ArrayList<String> getDisplayList(ArrayList<Song> sList){
		ArrayList<String> displayList = new ArrayList<>();
		for(Song s : sList) {
			displayList.add(s.display());
		}
		return displayList;
	}
	
	//loads all songs in file to ArrayList and returns it;
	public ArrayList<Song> getList(){
				BufferedReader reader = null;
				ArrayList<Song> list = new ArrayList<>();
				try {
					reader = new BufferedReader(new FileReader("/app/songs.txt"));
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
		
	public void start() {
		//Initializes observable list to list of songs
		obvList = FXCollections.observableArrayList();
		listView.setItems(obvList);
	}
	
}
