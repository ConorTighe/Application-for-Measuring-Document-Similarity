package ie.gmit.sw;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Thread pool that takes care of executing the job requests.
public class WorkerPool {
	
    ExecutorService executor;
    
	private WorkerPool() {
		try {
		executor = Executors.newFixedThreadPool(5);
		System.out.println("Pool ready..");
		}catch(Exception e) {
			System.out.println("Error setting up pool: ");
			e.printStackTrace();
		}
	}
	
	// For adding one of our Jobs to the Pool for execution by the pool threads
	public String addJob(WorkerPlan job) {
		String result;
        // Adding new job to our queue
        System.out.println("Adding job to queue: " + job.getJobName());
        executor.execute(job);
        result = job.getServerResult();
        return result;
	}
}