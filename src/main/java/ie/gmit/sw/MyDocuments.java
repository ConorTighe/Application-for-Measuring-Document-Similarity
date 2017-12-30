package ie.gmit.sw;

import java.io.File;
import com.db4o.*;

public class MyDocuments implements DocumentMiddleware {
    
	private String title;
	private final String DB_NAME = "DocumentDB";
	static final long serialVersionUID = 1L;
	
	ObjectContainer db;
    
	public MyDocuments(String s) throws Exception {
		this.title = s;
		loadDocument(DB_NAME);
	}

	public String compareDocument(String s, File f) throws Exception {
		display();
		return null;
	}

	public String lookupDocument(String s, File f) throws Exception {
		display();
		return null;
	
	}
	
	public void display() {
	      System.out.println("Using " + getTitle());
	}
	
	private void loadDocument(String fileName){
	      System.out.println("Loading " + fileName);
	      
	      ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded
					 .newConfiguration(), fileName);
	 }

	public String getTitle() {
		return title;
	}

}
