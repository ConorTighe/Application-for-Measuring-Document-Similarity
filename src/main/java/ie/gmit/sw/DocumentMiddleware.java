package ie.gmit.sw;

import java.io.File;

public interface DocumentMiddleware {
	
	public String compareDocument(String s, File f) throws Exception;
	
	public String lookup() throws Exception;
	
}
