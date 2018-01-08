package ie.gmit.sw;

import java.util.ArrayList;

// Acts as a bridge between classes.
public interface DocumentMiddleware {
	
	public ArrayList<String> compareDocument() throws Exception;
	
	public String addDocument(String s,String a, ArrayList<String> f) throws Exception;
	
}
