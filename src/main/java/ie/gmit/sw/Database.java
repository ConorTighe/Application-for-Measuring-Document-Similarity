package ie.gmit.sw;

import java.io.File;
import java.util.ArrayList;

public class Database {

	private String fileName;
	private ArrayList<String> text;
	private ArrayList<String> dbResults;
	private DocumentProxy DP;
	
	public Database(String s, ArrayList<String> file) {
		this.text = file;
		this.fileName = s;
		DP = new DocumentProxy(this.fileName,this.text);
	}

	public ArrayList<String>  compareHandeler() throws Exception {
		dbResults = DP.compareDocument();
		return dbResults;
	}

	public String addHandler() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
