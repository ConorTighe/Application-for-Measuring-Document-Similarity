package ie.gmit.sw;

public class CompareWorker implements WorkerPlan {

	private String title;
	private String jobName;
	private String serverResult;
	
	public CompareWorker(String t) {
		this.title = t;
		setJobName("Compare " + title + " server documents");
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

	public String getServerResult() {
		return serverResult;
	}

	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
