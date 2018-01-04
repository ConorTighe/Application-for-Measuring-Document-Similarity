package ie.gmit.sw;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.http.Part;

public class MenuService {
	
	WorkerPool pool = new WorkerPool();
	public MenuService() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<String> CompareService(String t, Part p) {
		ArrayList<String> result;
		CompareWorker compareJob = new CompareWorker(t,p);
		result = pool.addJob(compareJob);
		return result;
	}

	public ArrayList<String> AddingService(String t, Part p) {
		ArrayList<String> result;
		AddingWorker addingJob = new AddingWorker(t,p);
		result = pool.addJob(addingJob);
		return result;
	}
	
}
