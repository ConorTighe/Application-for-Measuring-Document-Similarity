package ie.gmit.sw;

// For setting up new documents
public class Document extends DocumentLayout {

	// set title and author and also prepare our document location
	public Document(String title, String author) {
		setTitle(title);
		setAuthor(author);
		loadDoc();
	}
}
