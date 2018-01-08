package ie.gmit.sw;

import java.util.ArrayList;

import javax.servlet.http.Part;
// Menu service, here we make requests to the thread factory passsing them the runnable code
public class MenuService {
	
	// factory instance
	WorkerThreadFactory WorkerFactory = new WorkerThreadFactory();
	
	public MenuService() {
		
	}
	
	public ArrayList<String> CompareService(String t, Part p, ArrayList<String> result) throws InterruptedException {
		// Thread and compare runnable created
		Thread job;
		CompareWorker compareJob = new CompareWorker(t,p);
		// Set Jobs name and prefix
		WorkerFactory.setPrefix(compareJob.getJobName());
		// get new thread from factory
		job = WorkerFactory.newThread(compareJob);
		try {
			// start thread and join it to service process
			job.start();
			job.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Call and return results from completed compareJob
		result = compareJob.getServerResult();
		return result;
	}

	public ArrayList<String> AddingService(String t,String a, Part p) {
		// Thread for job
		Thread job;
		ArrayList<String> result = null;
		// Runnable created with title,author and servlet part passed to it
		AddingWorker addingJob = new AddingWorker(t,a,p);
		// set prefix as jobs name
		WorkerFactory.setPrefix(addingJob.getJobName());
		// get new job from factory
		job = WorkerFactory.newThread(addingJob);
		try {
			// start and join to service
			job.start();
			job.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// return results
		result = addingJob.getServerResult();
		return result;
	}
	
}
