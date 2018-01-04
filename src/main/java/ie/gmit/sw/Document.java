package ie.gmit.sw;

public class Document extends DocumentLayout {

	public Document() {
		setTitle("Untitled");
		setAuthor("Unknown");
	}
	
	public Document(String title, String author) {
		setTitle(title);
		setAuthor(author);
	}
	
}
