package ie.gmit.sw;

import java.util.ArrayList;

public class Database {

	private String fileName;
	private ArrayList<String> text;
	private ArrayList<String> dbResults;
	private DocumentProxy DP;
	
	public Database() {
	}
	
	public Database(String s, ArrayList<String> file) {
		this.text = file;
		this.fileName = s;
		DP = new DocumentProxy(this.fileName,this.text);
	}

	public ArrayList<String>  compareHandler() throws Exception {
		dbResults = DP.compareDocument();
		return dbResults;
	}

	public String addHandler(String name, String author, ArrayList<String> f) throws Exception {
		String response;
		response = DP.addDocument(name, author, f);
		return response;
	}

}
