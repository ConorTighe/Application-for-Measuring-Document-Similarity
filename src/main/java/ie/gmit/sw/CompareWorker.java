package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.servlet.http.Part;

/* This is the runner class for comparing a file to files on the server */
public class CompareWorker implements WorkerPlan {

	// variables
	private String title;
	private Part document;
	private String jobName;
	private ArrayList<String> serverResult;
	Database db;
	
	// Constructor
	public CompareWorker(String t, Part d) {
		this.title = t;
		this.document = d;
		setJobName("Compare " + title + " to server documents");
	}
	
	// Runnable code
	public void run() {
		String line = null;
		ArrayList<String> lines = new ArrayList<String>();
		/* This is where I first convert the servlet part to a buffer
		 * reader and then divide the reader into individual string representing lines of the document. 
		 * I then turn these lines into smaller units known as shingles*/
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(document.getInputStream()));
			while ((line = br.readLine()) != null) {
				// Split lines into shingles
				String[] words = line.split(" ");    
				
				for ( String w : words) {
					lines.add(w);
				}	
			}
			
		} catch (IOException e) {
			System.out.println(jobName + " has failed!");
			e.printStackTrace();
		}
		
		try {
			// contact database
			serverResult = contactDatabase(title,lines);
			System.out.println("Null? : " + serverResult);
			setServerResult(serverResult);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Getters and Setters
	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public ArrayList<String> getServerResult() {
		return serverResult;
	}

	public void setServerResult(ArrayList<String> sResult) {
		this.serverResult = sResult;
	}
	
	public String getTitle() {
		return title;
	}
	
	// This handles contacting the server
	public ArrayList<String> contactDatabase(String s,ArrayList<String> text) throws Exception {
		System.out.println("Sending file to databse...");
		db = new Database(s,text);
		System.out.println("Files being compared...");
		return db.compareHandler();
	}
	
}
