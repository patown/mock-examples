package demo.org.powermock.examples.localField;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReaderDemo {

	public static String read(String path) throws IOException {
		String result = "";

		InputStream in = new FileInputStream(path);
		InputStreamReader isr = new InputStreamReader(in);
	
		BufferedReader br = new BufferedReader(isr);

		for (String line = br.readLine(); line != null; line = br.readLine()) {
			result+=line;
		}
		isr.close();
		return result;
	}
}
