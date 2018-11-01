package demo.org.powermock.examples.Properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesClass {
	private	Properties prop= new Properties();	
	public PropertiesClass() {
		load();
	}
	
	
	public void load()  {
		prop= new Properties();
		InputStream in;
		try {
			in = this.getClass().getResourceAsStream("a.properties");
		prop.load(in);
		in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public String print(String key) {
		return prop.getProperty(key);
	}

}
