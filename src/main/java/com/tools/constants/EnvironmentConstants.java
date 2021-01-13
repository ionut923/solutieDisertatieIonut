package com.tools.constants;

import com.tools.persistence.PropertyFileReader;

public interface EnvironmentConstants {

	public static final String BASE_URL = PropertyFileReader.getEnvConstantsItem("BASE_URL");
	public static final String PRODUCT_DETAIL_PAGE_URL = PropertyFileReader.getEnvConstantsItem("PRODUCT_DETAIL_PAGE_URL");
	public static final String USER = PropertyFileReader.getEnvConstantsItem("USER");
	public static final String PASS = PropertyFileReader.getEnvConstantsItem("PASS");
	
}
