package ie.gmit.sw;

public interface WorkerPlan extends Runnable {

	// For threads to run the code
	public void run();
	
	// All threads will need to return a result to user
	public String getServerResult();
	
	// Let us know what the thread is working on
	public String getJobName();
	
}