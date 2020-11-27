package PageObjectModel.NTTData.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadFromProperties {
	public String readProperties(String key) {
		String value = null;
		try {
			FileInputStream stream = new FileInputStream("./config.properties");
			Properties prop = new Properties();
			prop.load(stream);
			value = prop.getProperty(key);
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		}
		return value;
	}
}
