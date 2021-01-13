package com.tools.persistence;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.tools.constants.UrlConstants;

public class PropertyFileReader {

	public static String getEnvConstantsItem(String key) {

		Properties prop = new Properties();
		InputStream input = null;

		String value = "";

		try {
			input = new FileInputStream(UrlConstants.ENV_PATH + "environmentConstants.properties");
			prop.load(input);

			value = prop.getProperty(key);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return value;
	}

}
