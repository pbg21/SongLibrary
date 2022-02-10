package app;


/*
 * This Class stores the information of the song and allows for easy 
 * display of the songs information.
 * 
 * I implemented the compareTo method so we can call the Collections.sort method 
 * to sort the array for us. 
 */


public class Song implements Comparable<Song>{
		
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
	
	public String getArtist() {
		return artist;
	}

	public String getAlbum() {
		return album;
	}

	public String getYear() {
		return year;
	}

	public String getName() {
		return this.name;
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
