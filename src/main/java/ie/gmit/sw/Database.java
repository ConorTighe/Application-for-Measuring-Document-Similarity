package ie.gmit.sw;

import java.io.File;
import java.util.ArrayList;

public class Database implements DocumentMiddleware {

	private MyDocuments docs;
	private String fileName;
	private ArrayList<String> text;
	   
	public Database(String s, ArrayList<String> file) {
		this.text = file;
		this.fileName = s;
	}

	public String compareDocument(String s, ArrayList<String> f) throws Exception {
		if(docs == null){
			docs = new MyDocuments(fileName);
	    }
		docs.compareDocument(s, f);
		return null;
	}

	public String addDocument(String s, ArrayList<String> f) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
