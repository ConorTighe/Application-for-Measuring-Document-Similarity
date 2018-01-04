package ie.gmit.sw;

import java.io.File;
import java.util.ArrayList;

public class DocumentProxy implements DocumentMiddleware {

	private MyDocuments docs;
	private String fileName;
	private ArrayList<String> text;
	   
	public DocumentProxy(String s, ArrayList<String> file) {
		this.text = file;
		this.fileName = s;
	}

	public ArrayList<String> compareDocument() throws Exception {
		if(docs == null){
			docs = new MyDocuments(fileName, text);
	    }
		return docs.compareDocument();
	}

	public String addDocument(String s, ArrayList<String> f) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
