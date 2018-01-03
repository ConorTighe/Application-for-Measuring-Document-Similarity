package ie.gmit.sw;

import java.io.File;

import javax.servlet.http.Part;

public class MenuService {
	
	WorkerPool pool = new WorkerPool();
	public MenuService() {
		// TODO Auto-generated constructor stub
	}
	
	public String [] CompareService(String t, Part p) {
		String [] result;
		CompareWorker compareJob = new CompareWorker(t,p);
		result = pool.addJob(compareJob);
		return result;
	}

	public String [] AddingService(String t, Part p) {
		String [] result;
		AddingWorker addingJob = new AddingWorker(t,p);
		result = pool.addJob(addingJob);
		return result;
	}
	
}
