package ConnectionURL;

import java.net.*;
import java.io.*;

public class searchProfile {
	
	public static void searchPeople(String lien) throws Exception {
		
		URL oracle = new URL(lien);
		// http://www.linkedin.com/pub/guillaume-peoch/a2/37/513/
		// https://www.linkedin.com/pub/guillaume-peoch/a2/37/513
		URLConnection yc = oracle.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(
				yc.getInputStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null)
			System.out.println(inputLine);
		in.close();
	}
}