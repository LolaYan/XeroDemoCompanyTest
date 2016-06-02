/**
 * 
 */
package LolaAutomation.XeroDemoCompanyTest.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Lola
 * @email lolayan@outlook.com
 * 
 *        Note: 
 *        Set up the property file for Web, Android;
 *        Load the application.prperties from config folder LoadProperty
 *        by name in order to get the value of it
 */
public class PropertyLoader {

	private static final String WEB_PROP_FILE = "./config/webApplication.properties";
	private static final String ANDROID_PROP_FILE = "./config/androidApplication.properties";
	private static FileInputStream fs;
	private static Properties props = new Properties();

	private PropertyLoader() {

	}

	public static String loadProperty(String name) {
		String value = "";
		setFilePath(WEB_PROP_FILE);
		loadFS();
		if (name != null) {
			value = props.getProperty(name);
		}
		return value;
	}
	
	public static String loadAndroidProperty(String name) {
		String value = "";
		setFilePath(ANDROID_PROP_FILE);
		loadFS();
		if (name != null) {
			value = props.getProperty(name);
		}
		return value;
	}

	public static void setFilePath(String fileName) {
		try {
			fs = new FileInputStream(fileName);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public static void loadFS() {
		try {
			props.load(fs);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
