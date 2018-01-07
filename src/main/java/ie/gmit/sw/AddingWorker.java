package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.servlet.http.Part;

public class AddingWorker implements WorkerPlan {

	private String jobName;
	private String title;
	private String author;
	private Part document;
	Database db;
	private ArrayList<String> serverResult;
	
	public AddingWorker(String t,String author, Part d) {
		this.title = t;
		this.document = d;
		setJobName("Adding " + title + "to server");
	}

	public void run() {
		String line = null;
		ArrayList<String> lines = new ArrayList<String>();
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
			serverResult = sendFileToDatabase(title,author,lines);
			System.out.println("Null? : " + serverResult);
			setServerResult(serverResult);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

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
	
	public ArrayList<String> sendFileToDatabase(String s,String a, ArrayList<String> f) throws Exception {
		System.out.println("Sending file to databse...");
		db = new Database();
		System.out.println("Files being saved...");
		serverResult.add(db.addHandler(s,a,f));
		return serverResult;
	}

}
