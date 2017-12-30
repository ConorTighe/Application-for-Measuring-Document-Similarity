package ie.gmit.sw;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.http.Part;

// Thread pool that takes care of executing the job requests.
public class WorkerPool {
	
    private ExecutorService executor;
    private int taskNumber;
    
	public WorkerPool() {
		try {
		executor = Executors.newFixedThreadPool(5);
		System.out.println("Pool ready..");
		}catch(Exception e) {
			System.out.println("Error setting up pool: ");
			e.printStackTrace();
		}
	}
	
	// For adding one of our Jobs to the Pool for execution by the pool threads
	public String[] addJob(WorkerPlan job) {
		String [] result;
        // Adding new job to our queue
		TaskAdded();
        System.out.println("Adding job " + getTaskNumber() + " to queue: " + job.getJobName());
        executor.execute(job);
        // Return results
        result = job.getServerResult();
        return result;
	}
	
	// Increase task number
	private void TaskAdded() {
		taskNumber++;
	}

	// Get task number
	public int getTaskNumber() {
		return taskNumber;
	}
	
}