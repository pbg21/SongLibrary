package views;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import app.Song;
import app.SongLib;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/*
 * The controller is going to do most of the work in this program. 
 * The start method is going to instancialize all the FX elements and add event handlers to them
 * The rest of the code is going to implement those event handlers. 
 * 
 * 
 */


public class SLController {
	ArrayList<Song> songList;
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
	
/*
 * We want to be able to select objects in the list and 
 * 
 */
	
	
	
	public void start(Stage mainStage) {
		//Initializes observable list to list of songs
		songList = SongLib.getSongList();
		obvList = FXCollections.observableArrayList(getDisplayList(songList));
		
		//Setting ListView Properties and event handling
		listView.setItems(obvList);
		listView.getSelectionModel().select(0);
		listView.getSelectionModel().selectedItemProperty().addListener((obvList)->showInfo());
		
		//
		
		
		//Setting Info and Delete Section events
		delete.setDisable(true);
		name.setText("");
		artist.setText("");
		album.setText("");
		
		
		//Setting adding events
		
		
		
	}
	
	//Method Displays the info of the selected Obv item
	public void showInfo() {
		name.setText(songList.get(listView.getSelectionModel().getSelectedIndex()).getName());
		artist.setText(songList.get(listView.getSelectionModel().getSelectedIndex()).getArtist());
		album.setText(songList.get(listView.getSelectionModel().getSelectedIndex()).getAlbum());
		year.setText(songList.get(listView.getSelectionModel().getSelectedIndex()).getYear());
		delete.setDisable(false);
	}
	
	//Deletes song that is selected by the listView
	public void delete(ActionEvent e) {
		
	}
	
	//adds the song that was typed by the user
	public void add(ActionEvent e) {
		
	}
	
	
	
}
