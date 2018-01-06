package ie.gmit.sw;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.http.Part;

public class MenuService {
	
	WorkerThreadFactory WorkerFactory = new WorkerThreadFactory();
	
	public MenuService() {
		
	}
	
	public ArrayList<String> CompareService(String t, Part p, ArrayList<String> result) throws InterruptedException {
		Thread job;
		CompareWorker compareJob = new CompareWorker(t,p);
		WorkerFactory.setPrefix(compareJob.getJobName());
		job = WorkerFactory.newThread(compareJob);
		try {
			job.start();
			job.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = compareJob.getServerResult();
		return result;
	}

	public ArrayList<String> AddingService(String t, Part p) {
		ArrayList<String> result = null;
		AddingWorker addingJob = new AddingWorker(t,p);
	    //result = pool.addJob(addingJob);
		return result;
	}
	
}
