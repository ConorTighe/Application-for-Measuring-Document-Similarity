package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.servlet.http.Part;
/* This is the runner class for adding a file to the server */
public class AddingWorker implements WorkerPlan {

	// Variables
	private String jobName;
	private String title;
	private String author;
	private Part document;
	Database db;
	private ArrayList<String> serverResult;
	
	// Constructor
	public AddingWorker(String t,String author, Part d) {
		this.title = t;
		this.document = d;
		setJobName("Adding " + title + "to server");
	}

	// Runnable code
	public void run() {
		String line = null;
		ArrayList<String> lines = new ArrayList<String>();
		/* Below I converted the part input stream to a buffer reader and then used the reader to place
		 * each line into an array list so it can be easily unpacked on the server */
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(document.getInputStream()));
			while ((line = br.readLine()) != null) {
					lines.add(line);
			}
			
		} catch (IOException e) {
			System.out.println(jobName + " has failed!");
			e.printStackTrace();
		}
		
		try {
			// Send file to database
			serverResult = sendFileToDatabase(title,author,lines);
			setServerResult(serverResult);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Getters and Setters
	public ArrayList<String> getServerResult() {
		return serverResult;
	}

	public void setServerResult(ArrayList<String> serverResult) {
		this.serverResult = serverResult;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	// Sends contents of file to database
	public ArrayList<String> sendFileToDatabase(String s,String a, ArrayList<String> f) throws Exception {
		System.out.println("Sending file to databse...");
		db = new Database();
		System.out.println("Files being saved...");
		serverResult.add(db.addHandler(s,a,f));
		return serverResult;
	}

}
