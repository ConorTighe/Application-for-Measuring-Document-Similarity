package ie.gmit.sw;

/* The blueprint for all our document objects for db4o, decided to use the Builder pattern for this
 * as it would allow us to easily add documents later on, following closed for 
 * Modifications open for extension principle */
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
	
	public void loadDoc() {
		this.location = "src\\main\\resources\\" + getTitle() + ".txt";
	}

	@Override
	public String toString() {
		return location;
	}
	
}
