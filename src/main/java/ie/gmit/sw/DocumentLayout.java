package ie.gmit.sw;

import java.util.ArrayList;

/* The blueprint for all our document objects for db4o */
public abstract class DocumentLayout {

	private String title;
	private String location;
	private String author;
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}
	
	public String getLocation() {
		return location;
	}
	
	public String loadDoc() {
		this.location = "AOOProject//DatabaseFiles//" + getTitle() + ".txt";
		return location;
	}
	
}
