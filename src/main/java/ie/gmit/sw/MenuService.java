package ie.gmit.sw;

import java.io.File;

import javax.servlet.http.Part;

public class MenuService {
	
	WorkerPool pool = new WorkerPool();
	public MenuService() {
		// TODO Auto-generated constructor stub
	}
	
	public String [] CompareService(String t, Part p) {
		String [] res = null;
		
		return res;
	}

	public String [] AddingService(String t, Part p) {
		String [] result;
		AddingWorker lookupJob = new AddingWorker(t,p);
		result = pool.addJob(lookupJob);
		return result;
	}
	
}
