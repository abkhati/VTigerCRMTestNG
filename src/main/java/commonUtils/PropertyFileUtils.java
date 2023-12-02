package commonUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtils {
	
	public String getDataFromPropetyFile(String key) throws IOException 
	{
		FileInputStream file = new FileInputStream("src\\test\\resources\\Frameworks.properties");
		Properties p = new  Properties();
		p.load(file);
		String value = p.getProperty(key);
		return value;
	}

	

}
