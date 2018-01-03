package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.servlet.http.Part;

public class CompareWorker implements WorkerPlan {

	private String title;
	private Part document;
	private String jobName;
	private String [] serverResult;
	Database db;
	public CompareWorker(String t, Part d) {
		this.title = t;
		this.document = d;
		setJobName("Compare " + title + "to server documents");
	}
	
	public void run() {
		String line = null;
		ArrayList<String> lines = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(document.getInputStream()));
			while ((line = br.readLine()) != null) {
				lines.add(line);
				System.out.println(line);
			}
			
		} catch (IOException e) {
			System.out.println(jobName + " has failed!");
			e.printStackTrace();
		}
		
		try {
			contactDatabase(title,lines);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String [] getServerResult() {
		return serverResult;
	}

	public String getTitle() {
		return title;
	}
	
	public void contactDatabase(String s,ArrayList<String> text) throws Exception {
		System.out.println("Sending file to databse...");
		Database db = new Database(s,text);
		System.out.println("Files being compared...");
		db.compareDocument(s, text);
	}
	
}
