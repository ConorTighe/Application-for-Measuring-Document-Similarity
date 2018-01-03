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
	final static String DB_NAME = System.getProperty("user.home") + "/formula1.db4o";
	static final long serialVersionUID = 1L;
	DocumentLayout document = new Document("ArtOfWar","Sun Tzu");
	ObjectContainer db;
    
	public MyDocuments(String s, ArrayList<String> t) throws Exception {
		this.title = s;
		this.text = t;
		//Set up DB
		initDB();
		ObjectSet result = db.queryByExample(Document.class);

		loadDocuments(result);
		
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

	public String compareDocument(String s, ArrayList<String> f) throws Exception {
		display();
		return null;
	}

	public String addDocument(String s, ArrayList<String> f) throws Exception {
		return null;
	
	}
	
	public void display() {
	      System.out.println("Using " + getTitle());
	}
	
	private void loadDocuments(ObjectSet set) throws IOException{
		
		String line = null;
		ArrayList<String> serverResults = new ArrayList<String>();
		String tempLocation = "";
		System.out.println(set.size());
		
		while(set.hasNext()) {
			DocumentLayout temp = new Document();
			System.out.println(set.next());
			temp = (DocumentLayout) set.next();
			tempLocation = temp.loadDoc();
			BufferedReader br = new BufferedReader(new FileReader(tempLocation));
			while ((line = br.readLine()) != null) {
				serverResults.add(line);
			}
			
			ArrayList<Integer> comparingList = new ArrayList<Integer>();
		    // adding default values as one
		    for (int a = 0; a < text.size(); a++) {
		        comparingList.add(0);

		    }
		    
			for(int counter = 0; counter < text.size(); counter++) {
			    if(serverResults.contains(text.get(counter))) {
			          comparingList.set(counter,1);
			      }
			  }
		}
		
	}

	public String getTitle() {
		return title;
	}

}
