package ie.gmit.sw;

import java.io.File;

public class Database implements DocumentMiddleware {

	 private MyDocuments docs;
	 private String fileName;
	   
	public Database(String fileName) {
		this.fileName = fileName;
	}

	public String compareDocument(String s, File f) throws Exception {
		if(docs == null){
			docs = new MyDocuments(fileName);
	    }
		docs.compareDocument(s, f);
		return null;
	}

	public String lookup() throws Exception {
		String res;
		if(docs == null){
			docs = new MyDocuments(fileName);
	    }
		res = docs.lookup();
		return res;
	}

}
