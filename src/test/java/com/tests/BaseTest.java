package com.tests;

import org.junit.Before;
import org.junit.runner.RunWith;

import net.serenitybdd.junit.runners.SerenityRunner;

@RunWith(SerenityRunner.class)
public class BaseTest {

	@Before
	public void setup() {
//		System.setProperty("http.proxyHost", "localhost");
//		System.setProperty("http.proxyPort", "8080");

		System.setProperty("runPlatform", "desktop");
		System.setProperty("runEnv", "env");
	}
}
