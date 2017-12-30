package ie.gmit.sw;

import javax.servlet.http.Part;

public class CompareWorker implements WorkerPlan {

	private String title;
	private Part document;
	private String jobName;
	private String [] serverResult;
	
	public CompareWorker(String t, Part d) {
		this.title = t;
		this.document = d;
		setJobName("Compare " + title + "to server documents");
	}
	
	public void run() {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return null;
	}
	
}
