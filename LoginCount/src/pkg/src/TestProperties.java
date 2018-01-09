package pkg.src;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
	
	public final static String PROPERTY_FILENAME = "Config/Test.properties";
	public Properties test_properties = new Properties();
	public static final String BROWSERTYPE = "BROWSERTYPE";
	public final static String IEBOWSERDRIVER = "IEBOWSERDRIVER";
	public final static String CHROMEDRIVER = "CHROMEDRIVER";
	public static final String IEBOWSERDRIVER64 = "IEBOWSERDRIVER64";
	public static final String FFBOWSERDRIVER = "FIREFOXDRIVER";
	
	
	public TestProperties() {
		try {
			test_properties.load(new FileInputStream(PROPERTY_FILENAME));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		assert !test_properties.isEmpty();
	}

	public String getProperty(final String key) {
		String property = test_properties.getProperty(key);
		return property != null ? property.trim() : property;
	}


}
