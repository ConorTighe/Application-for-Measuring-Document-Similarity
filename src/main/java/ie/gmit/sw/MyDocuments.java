package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.db4o.*;

public class MyDocuments implements DocumentMiddleware {
    
	private String title;
	private ArrayList<String> text;
	private ArrayList<String> results = new ArrayList<String>();
	final static String DB_NAME = System.getProperty("user.home") + "/formula1.db4o";
	static final long serialVersionUID = 1L;
	DocumentLayout document = new Document("ArtOfWar","Sun Tzu");
	ObjectContainer db;
	ObjectSet<Document> setResult;
	public MyDocuments(String s, ArrayList<String> t) throws Exception {
		this.title = s;
		this.text = t;
		//Set up DB
		initDB();
		this.setResult = db.queryByExample(document);
	
	}
	
	public void initDB(){
		db = Db4oEmbedded.openFile(Db4oEmbedded
				 .newConfiguration(), DB_NAME);
		
		try {
			db.store(document);
		}catch(Exception e){
			System.out.println("Problem setting up DB: ");
			System.out.println(e);
		}

	}

	public ArrayList<String> compareDocument() throws Exception {
		display();
		String line = null;
		ArrayList<String> serverResults = new ArrayList<String>();
		int match = 0;
		String tempLocation = "";
		System.out.println(setResult.size());
		
		while(setResult.hasNext()) {
			Document temp = (Document) setResult.next();
			System.out.println(temp);
			System.out.println("got here");
			BufferedReader br = new BufferedReader(new FileReader(temp.toString()));
			while ((line = br.readLine()) != null) {
				serverResults.add(line);
			}
			
			for(int counter = 0; counter < text.size(); counter++) {
			    if(serverResults.contains(text.get(counter))) {
			          match++;
			      }
			  }
			float percent = (float) match * 100 / text.size();
			System.out.println(temp.getTitle());
			System.out.println(temp.getAuthor());
			System.out.println(percent);
		    results.add(temp.getTitle()+ " by " + temp.getAuthor() + " - similarity: %" + percent);
		    br.close();
		}
		return results;
		
	}

	public String addDocument(String s, ArrayList<String> f) throws Exception {
		return null;
	
	}
	
	public void display() {
	      System.out.println("Using.. " + getTitle());
	}


	public String getTitle() {
		return title;
	}

}
