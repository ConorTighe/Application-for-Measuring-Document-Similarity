package ie.gmit.sw;

import java.util.ArrayList;

import javax.servlet.http.Part;

public class AddingWorker implements WorkerPlan {

	private String jobName;
	private String title;
	private Part document;
	private ArrayList<String> serverResult;
	
	public AddingWorker(String t, Part d) {
		this.title = t;
		this.document = d;
		setJobName("Adding " + title + "to server");
	}

	public void run() {
		// TODO Auto-generated method stub
	}

	public ArrayList<String> getServerResult() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobName() {
		// TODO Auto-generated method stub
		return null;
	}

}
