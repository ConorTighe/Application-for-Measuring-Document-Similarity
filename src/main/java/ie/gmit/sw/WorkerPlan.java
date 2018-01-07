package ie.gmit.sw;

import java.util.ArrayList;

public interface WorkerPlan extends Runnable {

	// For threads to run the code
	public void run();
	
	// All threads will need to return a list of results to user
	public ArrayList<String> getServerResult();
	
	// Let us know what the thread is working on
	public String getJobName();
	
}