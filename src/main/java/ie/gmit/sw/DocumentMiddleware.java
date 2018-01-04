package ie.gmit.sw;

import java.io.File;
import java.util.ArrayList;

public interface DocumentMiddleware {
	
	public ArrayList<String> compareDocument() throws Exception;
	
	public String addDocument(String s, ArrayList<String> f) throws Exception;
	
}
