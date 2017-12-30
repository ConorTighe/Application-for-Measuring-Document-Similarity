package ie.gmit.sw;

public class LookupWorker implements WorkerPlan {

	private String jobName;
	private String serverResult;
	
	public LookupWorker() {
		setJobName("Check server documents");
	}

	public void run() {
		// TODO Auto-generated method stub
	}

	public String getServerResult() {
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
