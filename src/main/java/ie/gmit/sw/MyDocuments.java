package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import com.db4o.*;

/* Class representing our documents and there details, this is what we use for directly interacting with
 * the files */
public class MyDocuments implements DocumentMiddleware {
    
	// Variables
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
		// Create db4o queue using class example
		this.setResult = db.queryByExample(document);
	
	}
	
	// Set up or database
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

	// Does actual comparing of user document and server docs
	public ArrayList<String> compareDocument() throws Exception {
		display();
		String line = null;
		ArrayList<String> serverResults = new ArrayList<String>();
		int match = 0;
		System.out.println(setResult.size());
		
		while(setResult.hasNext()) {
			// Get nth document and store it in a temp document object
			Document temp = (Document) setResult.next();
			// Read file location, toString will give us a handle on the documents text version
			BufferedReader br = new BufferedReader(new FileReader(temp.toString()));
			while ((line = br.readLine()) != null) {
				// Split lines into shingles
				String[] words = line.split(" ");    
				
				for ( String w : words) {
					serverResults.add(w);
				}
			}
			
			// for every matching word increase by 1
			for(int counter = 0; counter < text.size(); counter++) {
			    if(serverResults.contains(text.get(counter))) {
			          match++;
			      }
			  }
			// Work out similarity 
			float percent = (float) match * 100 / text.size();
			// show information of current document in console
			System.out.println(temp.getTitle());
			System.out.println(temp.getAuthor());
			System.out.println(percent);
			// add the results of the nth document to the array list
		    results.add(temp.getTitle()+ " by " + temp.getAuthor() + " - similarity: %" + percent);
		    br.close();
		}
		return results;
		
	}

	// Adding document to server
	public String addDocument(String name,String a, ArrayList<String> f) throws Exception {
		String res;
		// Create new file using given name
		FileWriter writer = new FileWriter("src\\main\\resources\\" + name + ".txt"); 
		// write our array list contents to file
		for(String str: f) {
		  writer.write(str);
		}
		// clean up resource
		writer.close();
		
		// new document object
		DocumentLayout newdocument = new Document(name,a);
		try {
			// store in db4o
			db.store(newdocument);
			res = name + "Saved to database";
		}catch(Exception e){
			System.out.println("Problem saving to DB: ");
			System.out.println(e);
			res = "Save failed";
		}
		return res;
	}
	
	// Simple menthod for letting us know the name of sent document
	public void display() {
	      System.out.println("Using.. " + getTitle());
	}

	// Getter
	public String getTitle() {
		return title;
	}

}
