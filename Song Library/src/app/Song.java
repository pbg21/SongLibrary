package app;
import java.util.ArrayList;
import java.util.Collections;

public class Song implements Comparable<Song>{
	
	public static ArrayList<Song> songList = new ArrayList<>();
	
	private String name;
	private String artist;
	private String album;
	private String year;
	
	public Song(String name, String artist, String album, String year) {
		this.name = name;
		this.artist = artist;
		this.album = album; 
		this.year = year;
	}
	
	public String display() {
		return String.format("%s, %s", name, artist);
	}
	
	public String toString() {
		return String.format("%s, %s, %s, %s", name, artist, album, year);
	}

	@Override
	public int compareTo(Song s) {
		return (this.toString()).compareTo(s.toString());
	}
		
}
